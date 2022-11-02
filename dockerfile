# syntax=docker/dockerfile:1

FROM node:latest 

RUN mkdir -p /home/stpl/Desktop/node-docker 

WORKDIR /home/stpl/Desktop/node-docker

COPY package.json /home/stpl/Desktop/node-docker

RUN npm install 

COPY . /home/stpl/Desktop/node-docker
 
EXPOSE 3000

CMD [ "npm", "start" ]

