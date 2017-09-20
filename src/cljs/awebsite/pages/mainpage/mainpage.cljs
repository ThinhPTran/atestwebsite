(ns awebsite.pages.mainpage.mainpage
  (:require [awebsite.db :as mydb]
            [awebsite.pages.mainpage.subs :as mainpagesubs]
            [awebsite.pages.mainpage.handlers :as mainpagehandlers]
            [clojure.string :as str]
            [reagent.core :as reagent]))

(defn- Logo
  "Logo for AdminLTE template"
  []
  [:a.logo {:href "index2.html"}
   [:span.logo-mini [:b "TW"]]
   [:span.logo-lg [:b "A Tutorial Website"]]])

(defn- Navbar
  "Navbar for AdminLTE HTML template"
  []
  [:nav.navbar.navbar-static-top
   ;; SideBar toggle button
   [:a.sidebar-toggle {:onClick #(mainpagehandlers/toggle-left-sidebar)}]
   ;; Right Menu
   [:div.navbar-custom-menu
    [:ul.nav.navbar-nav]]])

(defn- LeftSidebar
  "Left side bar from AdminLTE HTML template"
  []
  [:aside.main-sidebar
   [:section.sidebar
    ; [:div.user-panel
    ;  [:div.pull-left
    ;   [:div {:style {:width "40px" :height "40px"}}]]
    ;
    ;  [:div.pull-left.info
    ;   [:p "Alexander Pierce"]
    ;   [:a {:href "#"} [:i.fa.fa-circle.text-success] "Online"]]]
    ;[:form.sidebar-form
    ; {:method "get", :action "#"}
    ; [:div.input-group
    ;  [:input.form-control
    ;   {:placeholder "Search...", :type "text", :name "q"}]
    ;  [:span.input-group-btn
    ;   [:button#search-btn.btn.btn-flat
    ;    {:type "submit", :name "search"}]]]]

    [:ul.sidebar-menu
     ;[:li.header "Content"]
     [:li.active
      [:a {:href "#"
           :onClick #(mainpagehandlers/set-main-page-content :dataanalysis)}
       [:i.fa.fa-laptop]
       [:span "Data Analysis"]]
      [:a {:href "#"
           :onClick #(mainpagehandlers/set-main-page-content :dataimporter)}
       [:i.fa.fa-upload.fa-lg]
       [:span "Data Importer"]]]]]])

(defn- RightSidebar
  "Right sidebar (control sidebar) from AdminLTE html template"
  []
  [:div
   [:aside.control-sidebar.control-sidebar-dark]
   [:div.control-sidebar-bg]])

(defn- Footer
  "Footer for AdminLTE HTML template"
  [{:keys [left-sidebar]}]
  [:a.logo {:href "index2.html"}
   [:span.logo-mini [:b "TW "]]
   [:span.logo-lg [:b "A Tutorial Website"]]])

(defn- wrapper-div-class
  "The class of the wrapper div. Handles the visibility of the Left Sidebar"
  [screen-size left-sidebar-on?]
  (str/join " " ["wrapper sidebar-mini"
                 (if (and (not= screen-size :xs)
                          (not left-sidebar-on?))
                   "sidebar-collapse")
                 (if (and (= screen-size :xs) left-sidebar-on?)
                   "sidebar-open")]))

(defn MainPage
  "Main Page based on AdminLTE HTML template"
  []
  (let [screen-size (get-in @mydb/app-state [:window :screen-size])
        mainpageoption (mainpagesubs/get-main-page-option)
        content (mainpagesubs/get-main-page-content)
        left-sidebar-on? (:left-sidebar-on? mainpageoption)]
    ;(.log js/console "left-sidebar-on?: " left-sidebar-on?)
    [:div {:class
           (if (:left-sidebar mainpageoption)
             (wrapper-div-class screen-size left-sidebar-on?)
             "wrapper")}
     ;; Navbar
     (when (:nav-bar mainpageoption)
       [:header.main-header
        [Logo]
        [Navbar]])
     ;; Left sidebar
     (when (:left-sidebar mainpageoption)
       [LeftSidebar])
     ;; Main content
     [:div {:class (str/join " "
                             ["content-wrapper"
                              (when-not (:left-sidebar mainpageoption)
                                "content-wrapper-no-sidebar")])}]
;;       (cond
;;         (= :welloverview content) [WellOverview]
;;         (= :dataanalysis content) [DataAnalysis]
;;         (= :dataimporter content) [DataImporter])]

     ;; Footer
     (when (:footer mainpageoption)
       [Footer {:left-sidebar (:left-sidebar mainpageoption)}])

     ;; Right sidebar
     (when (:right-sidebar mainpageoption)
       [RightSidebar])]))
