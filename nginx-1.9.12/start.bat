echo off
set nginx_home=./
if "%nginx_home:nginx=%"=="%nginx_home%" (
    set nginx_home="nginx-1.9.12"
)

cd %nginx_home%
tasklist | findstr /i "nginx.exe"

if %ERRORLEVEL% == 0 (
	goto :stop_nginx
	goto :start_nginx
	goto :eof
) else (
	goto :start_nginx
	goto :eof
)

:stop_nginx
	echo "nginx is running, stopping..."
	rem nginx -s stop
	TASKKILL /F /IM nginx.exe /T
	echo "stop ok"

:start_nginx
	echo "nginx is not running, starting"
	start "nginx" "nginx.exe"
	echo "start ok"