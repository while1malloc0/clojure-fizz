(ns fbaas.core)

; First version.
; (defn fizz-buzz [x]
;   (cond
;     (= (mod x 15) 0) "fizzbuzz"
;     (= (mod x 3) 0) "fizz"
;     (= (mod x 5) 0) "buzz"
;     :else (str x)))

; Second version. This is akin to an "optimal" solution in a language that
; favors mutation, but is a lot of work in Clojure. Why? It seems because
; Clojure shepherds us towards writing stateless functions. Redefining the
; state of a variable in each conditional is painful because that's not what
; we're really supposed to be doing
; (defn fizz-buzz [x]
;   (def msg "")
;   (if (= (mod x 3) 0) (def msg (str msg "fizz"))
;   (if (= (mod x 5) 0) (def msg (str msg "buzz")))
;   (if (= msg "") (def msg (str x)))
;   msg)

; Blog-ready :TM: solution. This is super overengineered, and in prod code I'd
; probably use the first solution, but it's kind of fun
(defn fizzy? [x]
  "fizzy? returns whether a number is divisble by three"
  (= (mod x 3) 0))

(defn buzzy? [x]
  "buzzy? returns whether a number is divisible by five"
  (= (mod x 5) 0))

(defn fizzbuzzy? [x]
  "fizzbuzzy? returns whether a number is divisble by 15"
  (and (fizzy? x) (buzzy? x)))

(defn fizz-buzz [x]
  (cond
    (fizzbuzzy? x) "fizzbuzz"
    (fizzy? x) "fizz"
    (buzzy? x) "buzz"
    :else (str x)))
