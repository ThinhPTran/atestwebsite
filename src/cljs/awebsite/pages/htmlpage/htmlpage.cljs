(ns awebsite.pages.htmlpage.htmlpage
  (:require [awebsite.db :as mydb]
            [awebsite.pages.mainpage.subs :as mainpagesubs]
            [awebsite.pages.mainpage.handlers :as mainpagehandlers]
            [clojure.string :as str]
            [reagent.core :as reagent]))


(defn HtmlPage
  []
  [:div "HTML main page"])
