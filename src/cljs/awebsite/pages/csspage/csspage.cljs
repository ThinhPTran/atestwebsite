(ns awebsite.pages.csspage.csspage
  (:require [awebsite.db :as mydb]
            [awebsite.pages.mainpage.subs :as mainpagesubs]
            [awebsite.pages.mainpage.handlers :as mainpagehandlers]
            [clojure.string :as str]
            [reagent.core :as reagent]))

(defn CssHome
  []
  [:div "Css Home"])

(defn CssIntroduction
  []
  [:div "Css Introduction"])

(defn CssSyntax
  []
  [:div "Css Syntax"])

(defn CssPage
  []
  (let [subcontent (mainpagesubs/get-main-page-subcontent)]
    (cond
        (= :css-home subcontent) [CssHome]
        (= :css-introduction subcontent) [CssIntroduction]
        (= :css-syntax subcontent) [CssSyntax])))
