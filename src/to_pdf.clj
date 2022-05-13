(ns to-pdf
  (:require [genera-downloader :refer [pages fetch-html]]
            [clojure.java.io :as io])
  (:import (com.itextpdf.html2pdf HtmlConverter)
           (javax.xml.parsers DocumentBuilderFactory)
           (org.xhtmlrenderer.pdf ITextRenderer)
           (org.w3c.dom Document)
           (java.io InputStream)))

(def first-name (first pages))

(defn save-reports-as-itextpdf
  []
  (with-open [in (fetch-html first-name)
              out (io/output-stream (str first-name ".pdf"))]
    (HtmlConverter/convertToPdf in out)))

(defn- doc ^Document [^InputStream stream]
  (-> (DocumentBuilderFactory/newDefaultInstance)
      .newDocumentBuilder
      (.parse stream)))

(defn save-reports-as-open-pdf
  []
  (let [renderer (new ITextRenderer)
        file (doc (fetch-html first-name))
        renderer (.setDocument renderer file "")
        out (io/output-stream (str first-name ".pdf"))]
    (.createPDF renderer out)))
