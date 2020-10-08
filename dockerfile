FROM node:8.15-alpine
RUN apk --no-cache add git

WORKDIR /usr/src/app

COPY package*.json ./

RUN npm install

COPY . .

EXPOSE 8070
CMD [ "npm", "start" ]