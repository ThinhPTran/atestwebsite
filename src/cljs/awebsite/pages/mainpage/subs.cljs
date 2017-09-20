(ns awebsite.pages.mainpage.subs
  (:require [reagent.core :as reagent]
            [awebsite.db :as mydb]))

(defn get-main-page-option []
  (get-in @mydb/app-state [:pages :mainpage :options]))

(defn get-main-page-content []
  (get-in @mydb/app-state [:pages :mainpage :content]))
