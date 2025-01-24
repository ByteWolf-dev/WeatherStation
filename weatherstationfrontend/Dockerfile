FROM node:latest as build

WORKDIR /usr/local/app
COPY ./ /usr/local/app

RUN npm install

RUN npm run build




FROM nginx:latest

COPY --from=build /usr/local/app/dist/weatherstationfrontend/browser /usr/share/nginx/html

EXPOSE 80

# # Build Stage
# FROM node:21.7.1 AS weatherstationfrontend

# WORKDIR /app

# COPY package*.json ./
# RUN npm install

# COPY . .
# RUN npm run build --configuration=production

# # Production Stage
# FROM nginx:latest

# # Copy built Angular files
# COPY --from=weatherstationfrontend /app/dist/weatherstationfrontend/ /usr/share/nginx/html

# # Copy custom Nginx configuration
# COPY nginx.conf /etc/nginx/conf.d/default.conf

# EXPOSE 80

# CMD ["nginx", "-g", "daemon off;"]
