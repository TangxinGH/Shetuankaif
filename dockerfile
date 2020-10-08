FROM node:current-alpine3.12
RUN sed -i 's/dl-cdn.alpinelinux.org/mirrors.tuna.tsinghua.edu.cn/g' /etc/apk/repositories
RUN apk --no-cache add git \
    && apk add tree \
	&& npm config set registry http://registry.npm.taobao.org

EXPOSE 8070
