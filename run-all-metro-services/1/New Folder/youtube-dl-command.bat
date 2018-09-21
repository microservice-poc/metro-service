set COMMAND=youtube-dl.exe 
set COMMAND=%COMMAND% --cookies cookies.txt 
set COMMAND=%COMMAND% --proxy odc-proxy.idc.oracle.com:80
set COMMAND=%COMMAND% --sleep-interval 25 --max-sleep-interval 55 
set COMMAND=%COMMAND% --user-agent "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0" 
set COMMAND=%COMMAND% --referer "https://www.lynda.com"
set COMMAND=%COMMAND% -o "%%(playlist)s_-_%%(playlist_id)s/%%(playlist_index)s_-_%%(title)s-(%%(width)sx%%(height)s)-{%%(id)s}.%%(ext)s"
set COMMAND=%COMMAND% "https://www.lynda.com/Chef-tutorials/Learning-Chef/585256-2.html"

%COMMAND%



rem youtube-dl.exe --cookies cookies.txt --sleep-interval 15 --max-sleep-interval 45 --user-agent "Mozilla/5.0 (Windows NT 6.1; WOW64; rv:35.0) Gecko/20100101 Firefox/35.0"  --referer "https://www.lynda.com" -o "%(playlist)s_-_%(playlist_id)s/%(playlist_index)s_-_%(title)s-(%(width)sx%(height)s)-{%(id)s}.%(ext)s"  https://www.lynda.com/Web-tutorials/Spring-Spring-Security/704153-2.html
