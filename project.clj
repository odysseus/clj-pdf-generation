(defproject reporting-eg "0.1.0-SNAPSHOT"
  :description "Reporting examples with pdf generation and psql backing"
  :url "http://example.com/FIXME"
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.6"]
                 [hiccup "1.0.5"]
                 [ring-server "0.3.1"]
                 [org.clojure/java.jdbc "0.2.3"]
                 [postgresql/postgresql "9.1-901.jdbc4"]
                 [clj-pdf "1.11.6"]]
  :plugins [[lein-ring "0.8.12"]]
  :ring {:handler reporting-eg.handler/app
         :init reporting-eg.handler/init
         :destroy reporting-eg.handler/destroy}
  :profiles
  {:uberjar {:aot :all}
   :production
   {:ring
    {:open-browser? false, :stacktraces? false, :auto-reload? false}}
   :dev
   {:dependencies [[ring-mock "0.1.5"] [ring/ring-devel "1.3.1"]]}})
