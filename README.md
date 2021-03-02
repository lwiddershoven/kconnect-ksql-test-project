# Test project for Kafka-based environment.

3 data owning microservices: customer, product, order.
3 kafka connect configurations
? ksql transformations to transform kafka connect data model to something public
schema registry to share the API
ksql cluster that generates pre-joined entity 'enriched order' in which order is enriched with order + product
1 kafka connect load enriched order into serving store (postgres). Store consists documents as-is.
1 service that serves the serving store.

Demonstrates how to do change-data-capture with postgres.
Demonstrates on how not to publish your internal database model to the outside world
Demonstrates how to create a nice maintenance friendly API (topic + message format) in Kafka
Demonstrates how to create serving caches for high consumer traffic while still allowing proper domain ownership.
