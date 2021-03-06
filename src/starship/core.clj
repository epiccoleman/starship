(ns starship.core)

(def ship (atom {:name "The Kestrel"
                 :hull 100 
                 :systems {:shield {:max-hp 3 :current-hp 3}
                           :weapon {:damage 10}}}))

(def bad-guy (atom {:name "Pirate Cruiser" 
                    :hull 80 
                    :systems {:shield {:max-hp 3 :current-hp 3}
                    :weapon {:damage 10}}}))


(defn has-shield? [ship]
  (and (get-in @ship [:systems :shield]))
       (< 0 (get-in @ship [:systems :shield :current-hp])))

(defn attack [attacker target]
  (let [damage (get-in @attacker [:systems :weapon :damage])]
    (swap! target update-in  
      (if (has-shield? target)
        [:systems :shield :current-hp]
        [:hull]) - damage)
    (println "Attack succeeded!")))
