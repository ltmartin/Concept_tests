FROM node:14-alpine3.17
WORKDIR HelloWorld
RUN npm init --yes
RUN npm install @inrupt/solid-client @inrupt/solid-client-authn-browser @inrupt/vocab-common-rdf
RUN npm install parcel-bundler
COPY helloWorld.css .
COPY index.html .
COPY index.js .
COPY package.json .
ENTRYPOINT ["npx", "parcel", "index.html"]
EXPOSE 1234