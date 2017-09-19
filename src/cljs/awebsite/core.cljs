(ns awebsite.core
  (:require [reagent.core :as reagent]
            [awebsite.pages.mainpage.mainpage :refer [MainPage]]
            [awebsite.pages.page404 :refer [Page404]]
            [awebsite.pages.loadingpage :refer [LoadingPage]]
            [awebsite.db :as mydb]))



;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Page

(defn main-panel []
  "The main reagent component"
  (let [current-page (:current-page @mydb/app-state)]
    (cond
      (= :home current-page) [MainPage]
      (= :page404 current-page) [Page404]
      :else [LoadingPage])))


;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; Initialize App

(defn dev-setup []
  (when ^boolean js/goog.DEBUG
    (enable-console-print!)
    (println "dev mode")))


(defn reload []
  (reagent/render [main-panel]
                  (.getElementById js/document "app")))


(defn ^:export main []
  (dev-setup)
  (reload))
