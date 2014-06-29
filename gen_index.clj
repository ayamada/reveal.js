
(require '[hiccup.core :as h])


(def re-parameters-src
  #"(?s)###_CLJSRC_BEGIN_###(.*?)###_CLJSRC_END_###")

(defn- load-parameters [tmpl]
  ;; tmplから上記正規表現で指示されている領域を取得し、
  ;; それを load-string した結果のmapを返す。
  ;; (つまり上記で囲まれた領域のコードはmapを返さなければならない)
  ;; 上記コードはそのままテンプレート内に残る為、
  ;; コメントアウト内(つまり「<!-- -->」)に入れておく事。
  (if-let [m (re-find re-parameters-src tmpl)]
    (let [
          ;; TODO: 上記通りの実装を行う
          clj-string (second m)
          result-map (load-string clj-string)
          ]
      result-map)
    {}))

(defn- apply-parameters-to-tmpl [tmpl parameters]
  (if-not (seq parameters)
    tmpl
    (let [[k v] (first parameters)
          re (re-pattern (str "(?i)###\\Q" (name k) "\\E###"))
          data (cond
                 (nil? v) ""
                 (string? v) v
                 (not (coll? v)) (str v)
                 (not (keyword? (first v))) (apply str (map #(h/html %) v))
                 :else (h/html v))
          ]
      (recur (clojure.string/replace tmpl re data) (rest parameters)))))

(defn- doit [tmpl-path dst-path]
  (let [tmpl (slurp tmpl-path)
        parameters (load-parameters tmpl)
        result (apply-parameters-to-tmpl tmpl parameters)
        ]
    (spit dst-path result)))

(defn- usage [cmd]
  (println "usage:" "lein exec -p" cmd " src-template-file dst-file"))



(let [[cmd tmpl-path dst-path] *command-line-args*]
  (if (and tmpl-path dst-path)
    (doit tmpl-path dst-path)
    (usage cmd)))

