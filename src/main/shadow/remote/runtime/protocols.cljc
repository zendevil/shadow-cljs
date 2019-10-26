(ns shadow.remote.runtime.protocols)

(defprotocol Inspectable
  :extend-via-metadata true
  (describe [thing opts] "returns a map descriptor that tells system how to handle things further"))

(comment
  ;; nav feels limited by being in metadata
  ;; and coupled to the result of datafy
  ;; also has no notion of async built-in which could be a problem for CLJS

  ;; will still be used as the default descriptor impl

  ;; I would like to transmit metadata to the UI but by nav/datafy potentially
  ;; being in metadata I have to filter it first, which seems like a bad default

  ;; returns one-line text summary of something. default to edn preview, could be custom
  {::preview-self (fn [opts])
   ;; returns map description. similar to :summary view right now
   ::summary (fn [opts]) => {:entries 123 :obj-type "cljs.core/PersistentArrayMap"}
   ::preview-entry (fn [idx opts])
   ;; similar to nav, but navs by idx
   ::nav (fn [idx opts callback])})
