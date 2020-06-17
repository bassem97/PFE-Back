@echo off
:duplicate
for /l %%A in (28,1,50) do copy "C:\Users\khail\Desktop\pfe\PFE-Back\Images\3.jpg" "C:\Users\khail\Desktop\pfe\PFE-Back\Images\%%A.jpg"
goto duplicate