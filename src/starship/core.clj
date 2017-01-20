(ns starship.core)

(def ship (atom {:name "The Kestrel"
                 :hull 100 
                 :weapon {:damage 10}}))

(def bad-guy (atom {:name "Pirate Cruiser" 
                    :hull 80 
                    :weapon {:damage 10}}))

(defn status [ship] 
  (println "Ship: " (:name @ship)
  (println "Hull: " (:hull @ship))))

(defn attack [attacker target]
  (let [damage (:damage (:weapon @attacker))]
    (swap! target update-in [:hull] - damage)
    (println "Attack succeeded!")))


