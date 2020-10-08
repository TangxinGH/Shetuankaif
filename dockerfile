FROM node:8.15-alpine
RUN apk --no-cache add git \
    && apk add tree 

EXPOSE 8070
