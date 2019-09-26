in Spring 2.x only we need to change the client password in bCrypt format other that all no need to change any thing
  
Get BCrypt Password
====================

curl -X GET \
  'http://localhost:8080/encodeBCrypt?rawPassword=realspeed' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 46996f0d-4d39-f10b-f902-f01eaa2a4c7e'
  
Get Basic Auth Token
=====================

curl -X GET \
  'http://localhost:8080/encodeBase64?clientId=test&clientSecret=temp' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 074cc8f8-f2fe-4624-d113-a780e6e63774'
  
  

Get Auth Token Request
======================
curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'authorization: Basic dGVzdDp0ZW1w' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: b76bdf26-7902-4c78-b49b-44932fa329dc' \
  -d 'grant_type=password&username=admin.admin&password=realspeed'
  
  
Get Refresh Token Request
==========================

curl -X POST \
  http://localhost:8080/oauth/token \
  -H 'authorization: Basic dGVzdDp0ZW1w' \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: 90c2cef3-7faa-001b-045f-c620ae3c7f56' \
  -d 'grant_type=refresh_token&refresh_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbi5hZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJhdGkiOiI3NzE1NmI4OC03YTRlLTRhMzItOTk2NS1kMmE1ZTBlNGFjNmYiLCJleHAiOjE1Njk0MDk4NzQsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6IjRiNzJjYWI2LTFkMmItNDg2Zi05NTY3LTZiODg4ZjJkY2RjNyIsImNsaWVudF9pZCI6InRlc3QifQ.wvkRlqoDk6faYjG4YOFlymsHnIr2aFdt232wdBXoaiQ'
  

  
Get User Details
=================

curl -X GET \
  http://localhost:8080/auth-resource/users \
  -H 'authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJleHAiOjE1Njk0MDk3NDIsInVzZXJfbmFtZSI6ImFkbWluLmFkbWluIiwiYXV0aG9yaXRpZXMiOlsiU1RBTkRBUkRfVVNFUiIsIkFETUlOX1VTRVIiXSwianRpIjoiMWMyNzMxZmItZDhkZS00YmE3LWFlNTgtN2RlYTI3OWNiNGVlIiwiY2xpZW50X2lkIjoidGVzdCIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdfQ.-KxGgQAIqLSsJH9U6Ej4wKe_TgMQ3uDbonsnro-IFmI' \
  -H 'cache-control: no-cache' \
  -H 'postman-token: 13306ca2-7bee-7b46-9269-c1927795b139'
  
  
Revoke Access Token
=================
curl -X POST \
  http://localhost:8080/oauth/token/revoke \
  -H 'cache-control: no-cache' \
  -H 'content-type: application/x-www-form-urlencoded' \
  -H 'postman-token: fe833f86-7e2b-1728-9939-894d05ffcce5' \
  -d 'grant_type=revoke&access_token=eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1c2VyX25hbWUiOiJhZG1pbi5hZG1pbiIsInNjb3BlIjpbInJlYWQiLCJ3cml0ZSJdLCJhdGkiOiIxYzI3MzFmYi1kOGRlLTRiYTctYWU1OC03ZGVhMjc5Y2I0ZWUiLCJleHAiOjE1Njk0MTAwMTIsImF1dGhvcml0aWVzIjpbIlNUQU5EQVJEX1VTRVIiLCJBRE1JTl9VU0VSIl0sImp0aSI6IjA4ODZiZGM1LTZhOGEtNGQzOC1iZjY3LTA0ZjM5Yjg5MzA4YiIsImNsaWVudF9pZCI6InRlc3QifQ.P1YCsyrmv4Z0YE_UUcOObQw3PiYOGuLsYXxCCak10Sg'
  
  
