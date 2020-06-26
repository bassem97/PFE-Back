@echo off
:duplicate
for /l %%A in (221,1,300) do copy "C:\Users\khail\Desktop\pfe\PFE-Back\Images\6.jpg" "C:\Users\khail\Desktop\pfe\PFE-Back\Images\%%A.jpg"
goto duplicate