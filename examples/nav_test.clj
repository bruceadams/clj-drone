(ns clj-drone.example.nav-test
  (:require [clj-drone.core :refer :all]
            [clj-drone.navdata :refer :all]))

;; logging is configured to go to the logs/drone.log file

(println (java.util.Date.))
(set-log-data [:seq-num :flying :battery-percent
               :control-state :roll :pitch :yaw
               :velocity-x :velocity-y :velocity-z])
(drone-initialize)
(println "init-navdata" (java.util.Date.))
(drone-init-navdata)
(drone :flat-trim)
(println "ask for take off" (java.util.Date.))
(drone :take-off)
(Thread/sleep 6000)
(println "ask for landing" (java.util.Date.))
(drone :land)
(Thread/sleep 3000)
(println "end-navstream" (java.util.Date.))
(end-navstream)
(println (java.util.Date.))

;; (drone :emergency)
