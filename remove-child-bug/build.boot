(set-env!
  :dependencies '[[adzerk/boot-cljs          "1.7.228-1"]
                  [cljsjs/boot-cljsjs        "0.5.1"     :scope  "test"]
                  [adzerk/boot-reload        "0.4.6"]
                  [hoplon/boot-hoplon        "0.1.13"]
                  [hoplon/hoplon             "6.0.0-alpha13"]
                  [org.clojure/clojure       "1.7.0"]
                  [org.clojure/clojurescript "1.8.34"]
                  [cljsjs/jquery                  "1.11.3-0"]
                  [cljsjs/jquery-ui          "1.11.4-0"]
                  [tailrecursion/boot-jetty  "0.1.3"]]
  :source-paths #{"src"})

(require
  '[adzerk.boot-cljs         :refer [cljs]]
  '[adzerk.boot-reload       :refer [reload]]
  '[hoplon.boot-hoplon       :refer [hoplon prerender]]
  '[cljsjs.boot-cljsjs       :refer [from-cljsjs]]
  '[tailrecursion.boot-jetty :refer [serve]])

(deftask dev
  "Build remove-child-bug for local development."
  []
  (comp
    (watch)
    (from-cljsjs :profile :development)
    (speak)
    (hoplon)
    (reload)
    (cljs)
    (serve :port 8000)))
