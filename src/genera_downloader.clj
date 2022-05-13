(ns genera-downloader
  (:require [clj-http.client :as client]
            [clojure.java.io :as io])
  (:import (java.io InputStream)))

(def cookie
  "CHANGE THIS VAR
  ============
  Get it by logging into your Genera account, pressing F12, press Network, refresh the page,
  click on any request to exames.genera.com.br and search for the content of Cookie in Request Headers"

  "")

(def pages [{:name "ancestralidade"}
            {:name "linhagem-materna"}
            {:name "linhagem-paterna"}
            {:name "genera-nutri"
             :path "caracteristica/"}
            {:name "genera-fit"
             :path "caracteristica/"}
            {:name "genera-skin"
             :path "caracteristica/"}
            {:name "genera-aging"
             :path "caracteristica/"}
            {:name "genera-you"
             :path "caracteristica/"}
            {:name "genera-farma"
             :path "caracteristica/"}])

(defn name->uri
  [name path]
  (str "https://exames.genera.com.br/"
       path
       name
       "/imprimir"))

(defn fetch-html
  (^InputStream [name] (fetch-html name ""))
  (^InputStream [name path]
   (let [uri (name->uri name path)]
     (:body (client/get uri
                        {:headers {"Cookie" cookie} :as :stream})))))

(defn save-reports-as-html
  []
  (doseq [{:keys [name path]} pages]
    (with-open [in (fetch-html name path)
                out (io/output-stream (str "out/" name ".html"))]
      (io/copy in out))))
