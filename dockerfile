FROM node:8.15-alpine
RUN apk --no-cache add git

EXPOSE 8070
CMD [ "npm", "start" ]