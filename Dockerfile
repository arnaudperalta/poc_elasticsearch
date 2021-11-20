FROM openjdk:11

COPY . /usr/src/app
WORKDIR /usr/src/app

RUN apt update
RUN apt install -y maven

CMD ["/bin/sh", "/usr/src/app/entrypoint.sh"]
