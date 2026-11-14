# Employee Management System

Java Swing employee and department management app. It keeps the Travel project’s fonts, colors, layout, and screen style. Employee and department records are held in memory while the app is running; this project does not use MySQL.

The app includes employee add, edit, delete, search, and list screens, plus department add, edit, delete, search, and list screens. The sample sign-in is `admin` / `123456`.

Build and run:

```powershell
cd "C:\Users\pulki\Desktop\NSP\EmployeeManagementSystem"
.\mvnw.cmd package
$sources = Get-ChildItem .\src\main\java -Recurse -Filter *.java | ForEach-Object FullName
New-Item -ItemType Directory -Force .\target\classes | Out-Null
javac -encoding UTF-8 -d .\target\classes $sources
if ($LASTEXITCODE -eq 0) { java -cp .\target\classes com.example.employeemanagementsystem.Main }
```
