# syntax=docker/dockerfile:1

FROM node:latest 

RUN mkdir -p /node-docker 

WORKDIR /node-docker

COPY package.json /node-docker

RUN npm install 

COPY . /node-docker
 
EXPOSE 8080

CMD [ "npm", "start" ]

