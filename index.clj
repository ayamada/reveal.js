<!doctype html>
<html lang="en">

  <head>
    <meta charset="utf-8">

    <title>###TITLE###</title>

    <!--
    <meta name="description" content="A framework for easily creating beautiful presentations using HTML">
    -->
    <meta name="author" content="atsuo yamada">

    <meta name="apple-mobile-web-app-capable" content="yes" />
    <meta name="apple-mobile-web-app-status-bar-style" content="black-translucent" />

    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">

    <link rel="stylesheet" href="css/reveal.min.css">
    <link rel="stylesheet" href="css/theme/default.css" id="theme">

    <!-- For syntax highlighting -->
    <link rel="stylesheet" href="lib/css/zenburn.css">

    <style><!--
      strong { color: red }
      --></style>

    <!-- If the query includes 'print-pdf', use the PDF print sheet -->
    <script>
    if( window.location.search.match( /print-pdf/gi ) ) {
            var link = document.createElement( 'link' );
            link.rel = 'stylesheet';
            link.type = 'text/css';
            link.href = 'css/print/pdf.css';
            document.getElementsByTagName( 'head' )[0].appendChild( link );
    }
    </script>

    <!--[if lt IE 9]>
    <script src="lib/js/html5shiv.js"></script>
    <![endif]-->
  </head>

  <body>

    <div class="reveal">

      <!-- Any section element inside of this container is displayed as a slide -->
      <div class="slides">

        <section>
        <h3>###TITLE###</h3>
        <p><small>by <a href="http://tir.jp/">技情研ネット 山田</a><br />at <a href="http://atnd.org/events/52421">大阪でClojure交流会</a> (2014/06/29)<br />(更新日時 2014/06/29)</small></p>
        </section>


        <section>
        <h2>デモ</h2>
        <div>(実演タイム)<br /><br />
          <small>(<a href="http://www.nicovideo.jp/watch/sm21698433" target="_blank">CLANのチュートリアル動画</a>作りました。<br />この動画での2:00～6:00相当の内容を Kyoto.lisp TT #2 にて実演しました。)</small></div>
        </section>


        <section>
        <h2>これは何？</h2>
        <ul>
          <li>これは、自分が作った<a target="_blank" href="https://github.com/ayamada/clan">CLAN</a>というもの</li>
          <li class="fragment">CLANは、Android向けアプリ構築キット</li>
          <li class="fragment">大雑把に言うと、Java用のゲーム構築ライブラリである<a target="_blank" href="http://libgdx.badlogicgames.com/">LibGDX</a>と、JVM向けLisp処理系であるClojureを、一緒に使えるようにしたもの</li>
        </ul>
        </section>


        <section>
        <section>
        <h2>LibGDXって何？</h2>
        <ul>
          <li>日本では全然流行ってないが、英語圏ではそこそこ人気があるゲーム構築ライブラリ</li>
          <li>一時期話題になった「<a target="_blank" href="http://www.ingress.com/">Ingress</a>」(実世界の地図情報とGPS情報を利用したオンライン陣取りゲーム、Google製)もLibGDXを使っている</li>
        </ul>
        <div>↓</div>
        </section>
        <section>
        <h2>もうちょっと詳しく！</h2>
        <ul>
          <li>LibGDXは、同じソースから、JREインストール済のPC(Windows, Mac, Linux, *BSD, etc...)、Android、iOS、html5のそれぞれに対するデプロイができる</li>
          <li>OpenGL(ES)を使って、一枚のスクリーンを毎フレーム更新していくタイプ。<br />各OSの標準のGUI等は基本使わない → ゲーム向き</li>
          <li>他の、Androidデプロイ可能なゲーム用フレームワークよりも速度面で優れている、らしい</li>
          <li>日本語のドキュメントや記事さえあれば日本でももっと流行ると思う</li>
        </ul>
        <div>↓</div>
        </section>
        <section>
        <h2>もっと知りたい！</h2>
        <ul>
          <li>LibGDXの開発者が書いた<a target="_blank" href="http://www.impressjapan.jp/books/3113">Androidゲームプログラミング A to Z</a>(<a target="_blank" href="http://www.amazon.co.jp/o/ASIN/4844331132/tirnejp-22">amazon</a>)という本がある。<br />これはLibGDXそのものの解説書ではないものの、これを読めば、LibGDXも含めたAndroid向けゲーム作成の概要が分かる。<br />良著、ただし2011年の本なのでちょっと情報が古くなっている。</li>
          <li><a target="_blank" href="http://libgdx.badlogicgames.com/">LibGDX公式サイト</a>にJavadoc、Wiki、Forumがあり、どれもまめに更新されている。もちろん英語。</li>
          <li>自分以外にもLibGDXを試して日本語でブログ記事を書いてる人が数人ぐらいいるので、ぐぐってみる</li>
        </ul>
        </section>
        </section>


        <section>
        <h2>Android用ゲームを作ってみた</h2>
        <p>タイトルは「ぶらり猫の旅」</p>
        <p><a target="_blank" href="https://play.google.com/store/apps/details?id=jp.ne.tir.vnctst.android.underworld">Google Play</a> にて普通に配布中</p>
        <p><a target="_blank" href="http://vnctst.tir.jp/ja/games/driftcat_underworld.html">VNCTST games</a> にてPC向けも配布中</p>
        <p><small>(当日は時間があったので、軽くデモプレイも行いました。<br />内容は <a target="_blank" href="http://www.nicovideo.jp/watch/sm20447162">http://www.nicovideo.jp/watch/sm20447162</a> とほぼ同じ)</small></p>
        <p>しかし完成までには色々と問題があった</p>
        </section>


        <section>
        <section>
        <h2>問題？</h2>
        <ul><li>気分よくClojureで普通にコード書いてPC上で問題なく動いた。しかしAndroid実機で動かしたらすごいガクガクしてまともに遊べない</li></ul>
        <div>↓</div>
        </section>
        <section>
        <h2>どう解決したの？</h2>
        <p>以下を満たす事で、実機でもフレームレートが改善した<br />(手元の端末ではほぼ60を達成)</p>
        <ul>
          <li>フレーム毎のrender()メソッド内ではオブジェクト生成をしてはならない。生成するとGCが動いてフレームレート大幅低下</li>
          <li>外部メソッドおよび関数呼び出しはDalvik VM上ではそこそこのコストがかかる。のでフレーム毎のrender()メソッド内では、可能な限りこれらの回数を少なくする</li>
        </ul>
        <div>↓</div>
        </section>
        <section>
        <h2>解決したんだ。よかったね。</h2>
        <p class="fragment">よくない。<br /><strong>関数型言語としてのClojureちゃんが息してない</strong></p>
        <ul>
          <li class="fragment">Clojureのimmutableなデータ型が使えない<br />(使うとGC発生)</li>
          <li class="fragment">mapやreduce(いわゆるfold)が使えない<br />(中で毎回関数呼び出しが発生するのと、中でconsしてるのでGC発生源になる)</li>
        </ul>
        <ul>
          <li class="fragment">Clojureは関数指向言語である前にLispなので、マクロを使えばある程度DSL化ができる。<br />とは言うもののcons類もmap類も封じられると非常にきつい</li>
        </ul>
        </section>
        </section>


        <section>
        <section>
        <h2>じゃあどうするの？</h2>
        <p>以下からどれかを選択する。</p>
        <div>↓</div>
        </section>
        <section>
        <h2>選択肢#1</h2>
        <ol start="1">
          <li>Android向けは諦める。<br />PC向けだけにする。<br />そして普通にClojure的なコードを書いて楽に開発する。<br />PC上で動かす分には、普通のClojure流儀のコードを書いても良好なパフォーマンスが出る。<br /><small>がんばればMinecraftレベルぐらいまで作りこめると思う</small></li>
        </ol>
        <div>↓</div>
        </section>
        <section>
        <h2>選択肢#2</h2>
        <ol start="2">
          <li>ゲームは諦め、<a href="https://github.com/alexander-yakushev/neko">Neko</a>だけを使って、普通のアプリを作る。<br />アプリなら毎フレーム描画する必要はないので、GCはそこまで多発しないし悪影響も少ない。<br /><small>便利で面白ければLINEみたいに大流行するかも？</small></li>
        </ol>
        <p><small>(Nekoは、Clojureで普通のAndroidアプリを書く為のフレームワーク)</small></p>
        <div>↓</div>
        </section>
        <section>
        <h2>選択肢#3</h2>
        <ol start="3">
          <li>通常のJavaによるAndroidアプリ開発と同様のテクニックを用いてカリカリにチューニングできるDSLを、マクロで構築する。<br />その上で、ぬるぬる動くAndroidネイティブゲームを作る。<br /><small>パズドラみたいに人気が出たらいいね</small></li>
        </ol>
        <div>↓</div>
        </section>
        <section>
        <h2>選択肢#4</h2>
        <ol start="4">
          <li>マクロを使って、前述の各問題(cons不可、関数呼び出し重い)を回避したLisp処理系をClojure上に構築する。<br />その上で楽にぬるぬる動くゲームを作る。<br /><small>GCを自前で用意する必要あり。高難易度</small></li>
        </ol>
        </section>
        </section>


        <section>
        <h2>まとめ</h2>
        <ul>
          <li class="fragment">とりあえず、まともな速度で動作するゲームが作れた</li>
          <li class="fragment">ただしAndroid実機でまともな速度で動かすには、Javaと同程度のチューニング労力をかける必要がある</li>
          <li class="fragment">Android実機で動かすのを諦めてPC配布のみにするなら、普通にClojureの流儀で書いて全く問題ない。<br />CLANでゲーム作って<a href="http://ch.nicovideo.jp/indies-game">ニコニコ自作ゲームフェス</a>とかに応募してみよう！</li>
          <li class="fragment">プログラムの実行速度が良好な事と、そのゲームが面白いかどうかという事は、直交する概念。<br /><strong>ぬるぬる動いてもクソゲーでは駄目です！</strong></li>
        </ul>
        </section>


        <section>
        <h1>おわり</h1>
        <p><small><a href="http://tir.jp/">技情研ネット</a> <a href="http://twitter.com/rnkv">山田</a></small></p>
        </section>


        <section>
        <section>
        <h2>おまけ</h2>
        <p>プレゼン後の質問タイム、懇親会で出た質問<br />(憶えてる分のみ。メモ取れなかったので超うろおぼえ)</p>
        <div>↓</div>
        </section>
        <section>
        <h4>「現在のAndroidではチューニング必須」との事だけど、<br />進化速度早いから<br />「端末およびDalvik VMの性能がPC並になるのを待つ」<br />という選択肢はどう？</h4>
        <ul><li>それは一般的にはアリだと思うんですが、自分は「このCLANで利益の出るゲーム/アプリを作って、可能なら会社勤務せずに暮らしていく」という事で作成したので、待っていると餓死してしまうので、自分的にはナシです！</li></ul>
        <div>↓</div>
        </section>
        <section>
        <h4>Android向けの最適化ってどんなの？</h4>
        <ul>
          <li>データはJavaの構造体やarrayに格納して破壊的変更して使う</li>
          <li>オブジェクトは最初に大量に生成してそれを使いまわす、途中で作らない。<br />いわゆるJavaのprimitive数値型はオブジェクトではないので途中で作りまくっても問題ないがBigInt化とboxingに注意</li>
          <li>mapやreduceは、dotimesやloop～recurで代用</li>
          <li>関数実行回数の多いところはマクロ/definlineでインライン化</li>
          <li>あとは既存のJavaでのAndroidアプリ最適化手法をぐぐって真似する！！！</li>
        </ul>
        <p>(このへん当日ちゃんと全部説明できてなかったと思う)</p>
        <div>↓</div>
        </section>
        <section>
        <h4>単なるconsが結構重いというのは意外</h4>
        <ul>
          <li>まだ調査中なんですが、AndroidのDalvik VMではどうも、cons等のオブジェクト生成(いわゆるJavaでのnew)を行うタイミングでGCを動かす判定も行われるようです。<br />なのでcons自体は重くはないけれど、同時にGCが動く時があり、それで0.05秒ぐらい世界が止まり、これが毎秒60フレーム更新するゲーム等では結構な問題になる、という感じ</li>
          <li>最初から大量にcons cell確保して自前で管理できればいいけど、残念ながらClojureの標準のcons cell(というかsequence)はimmutableつまり変更不可！</li>
          <li>何らかの抜け道がないかどうかはまだ模索中</li>
        </ul>
        </section>
        </section>

      </div>

    </div>

    <script src="lib/js/head.min.js"></script>
    <script src="js/reveal.min.js"></script>

    <script>
    // Full list of configuration options available here:
    // https://github.com/hakimel/reveal.js#configuration
    Reveal.initialize({
      controls: true,
      progress: true,
      history: true,
      center: true,
      rollingLinks: false,

      //theme: Reveal.getQueryHash().theme, // available themes are in /css/theme
      //transition: Reveal.getQueryHash().transition || 'default', // default/cube/page/concave/zoom/linear/fade/none

      // Parallax scrolling
      // parallaxBackgroundImage: 'https://s3.amazonaws.com/hakim-static/reveal-js/reveal-parallax-1.jpg',
      // parallaxBackgroundSize: '2100px 900px',

      // Optional libraries used to extend on reveal.js
      dependencies: [
        { src: 'lib/js/classList.js', condition: function() { return !document.body.classList; } },
        //{ src: 'plugin/markdown/marked.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
        //{ src: 'plugin/markdown/markdown.js', condition: function() { return !!document.querySelector( '[data-markdown]' ); } },
        { src: 'plugin/highlight/highlight.js', async: true, callback: function() { hljs.initHighlightingOnLoad(); } },
        //{ src: 'plugin/zoom-js/zoom.js', async: true, condition: function() { return !!document.body.classList; } },
        //{ src: 'plugin/notes/notes.js', async: true, condition: function() { return !!document.body.classList; } }
      ]
    });
    </script>

  </body>

</html>
<!--vim:set ft=html5 sw=2 sts=2 ts=2 et: -->
