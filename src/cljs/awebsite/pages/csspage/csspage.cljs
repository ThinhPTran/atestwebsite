(ns awebsite.pages.csspage.csspage
  (:require [awebsite.db :as mydb]
            [awebsite.pages.mainpage.subs :as mainpagesubs]
            [awebsite.pages.mainpage.handlers :as mainpagehandlers]
            [clojure.string :as str]
            [reagent.core :as reagent]))

(defn CssPage
  []
  [:div "Css main page"])
