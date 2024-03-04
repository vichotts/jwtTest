FROM ubuntu:latest
LABEL authors="Victor Hotts"

ENTRYPOINT ["top", "-b"]