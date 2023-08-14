# Demo Application

### The project goals
* to give a draft overview about my coding style, code structure & preferences
* to have the stage to discuss problems and questions during interviews on demand  

It is <b>NOT</b> a production ready code but rather a demo version in <i>a Getting Started style</i> 
with a reasonable invested time for further live discussion 

### Dev activities
* Kotlin & Java 17
* Springboot world 
* REST CRUD & pagination API
* Versioning of API
* Postgres db access & transactions
* Database schema evolution: Liquibase
* OpenAPI documentation & swagger
* Readiness & Liveness, healthcheck: actuator
* Observability: Prometheus metrics through micrometer 
* Traceability: micrometer brave
* Testcontainers: test container of Postgres db
* Hotswap: DevTools
* Docker-compose: set up local infra such as Postgres db & Admin UI

### Ops activities
* Build OCI image
  * manually through Dockerfile
  * FIXME: using [Cloud Native Buildpacks](https://buildpacks.io/) through [bootBuildImage](https://docs.spring.io/spring-boot/docs/current/gradle-plugin/reference/htmlsingle/#build-image) task. 
Firewall on a company laptop blocks some requests what caused:  javax.net.ssl.SSLHandshakeException: PKIX path building failed: sun.security.provider.certpath.SunCertPathBuilderException: unable to find valid certification path to requested target.
* Deploy to local k8s cluster: script to deploy Deployment, Service and Ingress 

### TODO
* Adopt ConfigMaps 
* Introduce GitHub Actions
  * to verify PullRequests and run tests 
  * to build the image, run tests and publish image to registry
* Versioning of app: nebula release plugin and etc.
