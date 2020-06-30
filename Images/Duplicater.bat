@echo off
:duplicate
for /l %%A in (300,1,500) do copy "C:\Users\khail\Desktop\pfe\PFE-Back\Images\6.jpg" "C:\Users\khail\Desktop\pfe\PFE-Back\Images\%%A.jpg"
goto duplicate