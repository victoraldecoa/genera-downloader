(defproject genera-downloader "0.1.0-SNAPSHOT"
  :description "TODO"
  :url "TODO"
  :license {:name "TODO: Choose a license"
            :url "http://choosealicense.com/"}
  :dependencies [[org.clojure/clojure "1.11.1"]
                 [com.stuartsierra/component "1.1.0"]
                 [clj-http "3.12.3"]
                 [clj-htmltopdf "0.2"]
                 [org.xhtmlrenderer/flying-saucer-pdf-openpdf "9.1.22"]
                 [com.itextpdf/html2pdf "4.0.2"]]
  :profiles {:dev {:dependencies [[org.clojure/tools.namespace "1.2.0"]
                                  [com.stuartsierra/component.repl "1.0.0"]]
                   :source-paths ["dev"]}})
