@echo off

:duplicate
for /l %%A in (1,1,16) do (
set /a random=%RANDOM% %%16
 copy "C:\Users\Bassem's PC\Desktop\PFE\PFE-Back\Images\2222222222.jpg" "C:\Users\Bassem's PC\Desktop\PFE\PFE-Back\Images\%random%.jpg"
)
goto duplicate