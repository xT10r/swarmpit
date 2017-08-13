(ns swarmpit.component.service.info.settings
  (:require [material.component :as comp]
            [rum.core :as rum]))

(enable-console-print!)

(rum/defc form < rum/static [service]
  (let [image-digest (get-in service [:repository :imageDigest])]
    [:div.form-service-view-group
     (comp/form-section "General settings")
     (comp/form-item "ID" (:id service))
     (comp/form-item "SERVICE NAME" (:serviceName service))
     (comp/form-item "CREATED" (:createdAt service))
     (comp/form-item "LAST UPDATE" (:updatedAt service))
     (comp/form-item "IMAGE" (get-in service [:repository :image]))
     (when (some? image-digest)
       (comp/form-item "IMAGE DIGEST" image-digest))
     (comp/form-item "MODE" (:mode service))]))

