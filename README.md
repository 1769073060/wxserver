# wxserver
开发个人服务号
docker build -t wxservice .
docker run -d --restart=always --name wxservice -v /usr/local/logs:/home/jar-logs -p 80:80 wxservice
