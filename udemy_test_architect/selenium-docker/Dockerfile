FROM bellsoft/liberica-openjdk-alpine:17.0.13

WORKDIR /home/selenium-docker

ADD target/docker-resources ./

ENTRYPOINT java -cp 'libs/*' \
                -Dselenium.grid.enabled=true \
                -Dselenium.grid.hubHost=${HUB_HOST} \
                -Dbrowser=${BROWSER} \
                org.testng.TestNG \
                -threadcount ${THREAD_COUNT} \
                test-suites/${TEST_SUITE}