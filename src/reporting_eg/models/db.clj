(ns reporting_eg.models.db
  (:require [clojure.java.jdbc :as sql]))

(def db {:subprotocol "postgresql"
         :subname "//localhost/reporting_eg"
         :user "ryan"
         :password ""})

(defn create-employee-table []
  (sql/create-table
    :employee
    [:name "varchar(50)"]
    [:occupation "varchar(50)"]
    [:place "varchar(50)"]
    [:country "varchar(50)"]))

(defn seed-user-data []
  (sql/with-connection
    db
    (create-employee-table)
    (sql/insert-rows
      :employee
      ["Albert Einstein", "Engineer", "Ulm", "Germany"]
      ["Alfred Hitchcock", "Movie Director", "London", "UK"]
      ["Wernher Von Braun", "Rocket Scientist", "Wyrzysk", "Poland"]
      ["Sigmund Freud", "Neurologist", "Pribor", "Czech Republic"]
      ["Mahatma Gandhi", "Lawyer", "Gujarat", "India"]
      ["Sachin Tendulkar", "Cricket Player", "Mumbai", "India"]
      ["Michael Schumacher", "F1 Racer", "Cologne", "Germany"])))

(defn read-employees []
  (sql/with-connection db
    (sql/with-query-results rs ["select * from employee"] (doall rs))))
