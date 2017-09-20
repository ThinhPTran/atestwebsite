(defproject awebsite "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.8.0"]
                 [org.clojure/clojurescript "1.9.229"]
                 [com.fzakaria/slf4j-timbre "0.3.7"]
                 [secretary "1.2.3" :exclusions [org.clojure/tools.reader]]
                 [cljsjs/bootstrap "3.3.6-1"]
                 [cljsjs/bootstrap-slider "7.0.1-0"]
                 [cljsjs/highcharts "5.0.4-0"]
                 [reagent "0.6.1"]]

  :min-lein-version "2.5.3"

  :source-paths ["src/clj" "src/cljs"]

  :plugins [[lein-cljsbuild "1.1.4" :exclusions [org.clojure/clojure]]
            [deraen/lein-sass4clj "0.3.1"]
            [lein-asset-minifier "0.3.2" :exclusions [org.clojure/clojure]]
            [lein-pdo "0.1.1"]]

  :clean-targets ^{:protect false} ["resources/public/js"
                                    "target"]

  :figwheel {:css-dirs ["resources/public/css"]}

  :profiles
  {:dev
   {:dependencies []

    :plugins      [[lein-figwheel "0.5.10" :exclusions [org.clojure/clojure]]]}}

  :cljsbuild
  {:builds
   [{:id           "dev"
     :source-paths ["src/cljs"]
     :figwheel     {:on-jsload "awebsite.core/reload"}
     :compiler     {:main                 awebsite.core
                    :optimizations        :none
                    :output-to            "resources/public/js/compiled/app.js"
                    :output-dir           "resources/public/js/dev"
                    :asset-path           "js/dev"
                    :source-map-timestamp true}}

    {:id           "min"
     :source-paths ["src/cljs"]
     :compiler     {:main            awebsite.core
                    :optimizations   :advanced
                    :output-to       "resources/public/js/compiled/app.js"
                    :output-dir      "resources/public/js/min"
                    :elide-asserts   true
                    :externs ["src/js/externs/adminlte.ext.js"]
                    :closure-defines {goog.DEBUG false}
                    :pretty-print    true}}]}

  :sass {:source-paths ["src/css"]
         :target-path "target/css"
         :output-style :compressed}

  :minify-assets {:assets {"resources/public/css/site.min.css" "target/css/"
                           "resources/public/js/compiled/site.min.js"
                           ["src/js/external/adminlte.js"]}}

  :aliases {"build-dev" ["do" ["sass4clj" "once"] ["minify-assets"] ["cljsbuild" "once" "dev"]]
            "build-min" ["do" ["sass4clj" "once"] ["minify-assets"] ["cljsbuild" "once" "min"]]
            "run-dev"   ["do" ["run" "dev"]]
            "start-dev" ["build-dev" "run-dev"]})




