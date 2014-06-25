
(require '[hiccup.core :as h])


(defn- gen-parameters [tmpl]
  ;; tmplから「!!!SRC!!!」と「!!!SRC!!!」で囲まれた領域を取得し、
  ;; load-stringした結果のmapを返す。
  ;; (つまり上記で囲まれた領域のコードはmapを返さなければならない)
  ;; 上記コードはそのままテンプレート内に残る為、
  ;; コメントアウト内(つまり「<!-- -->」)に入れておく事。
  (let [
        ;; TODO: 上記通りの実装を行う
        ]
    {
     :title "たいとる"
     ;<title>Unity3D内でClojureCLRを動かしてみる</title>
     :content "testだよー"
     }))

(defn- apply-parameters-to-tmpl [tmpl parameters]
  (if-not (seq parameters)
    tmpl
    (let [[k v] (first parameters)
          re (re-pattern (str "(?i)###" (name k) "###"))
          ]
      (recur (clojure.string/replace tmpl re v) (rest parameters)))))

(defn- doit [tmpl-path dst-path]
  (let [tmpl (slurp tmpl-path)
        parameters (gen-parameters tmpl)
        result (apply-parameters-to-tmpl tmpl parameters)
        ]
    (spit dst-path result)))

(defn- usage [cmd]
  (println "usage:" "lein exec -p" cmd " src-template-file dst-file"))



(let [[cmd tmpl-path dst-path] *command-line-args*]
  (if (and tmpl-path dst-path)
    (doit tmpl-path dst-path)
    (usage cmd)))

