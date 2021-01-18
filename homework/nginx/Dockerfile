FROM nginx

ENV WORKDIR=/application/nginx

WORKDIR ${WORKDIR}

COPY conf html img ${WORKDIR}

ENTRYPOINT ["nginx" ,"-c", "/application/nginx/conf/nginx.conf"]