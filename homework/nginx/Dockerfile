FROM nginx

ENV WORKDIR=/application/nginx/

WORKDIR ${WORKDIR}

COPY conf ${WORKDIR}/conf
COPY html /usr/share/nginx/html/resource/html
COPY img /usr/share/nginx/html/resource/img

ENTRYPOINT ["nginx" ,"-c", "/application/nginx/conf/conf.nginx", "-g", "daemon off;"]