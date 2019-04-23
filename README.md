# OAuth2 - Java Sample App for Review Board

## Table of Contents

* [First Use Instructions](#first-use-instructions)
* [Running the code](#running-the-code)
 
## First Use Instructions

1. Clone the GitHub repo to your computer
2. Fill in the [`application.properties`](src/main/resources/application.properties) file values (OAuth2AppClientId) by copying over from the keys section for your app.

## Running the code

Once the sample app code is on your computer, you can do the following steps to run the app:

1. cd to the project directory</li>
2. Run the command:`./gradlew bootRun` (Mac OS) or `gradlew.bat bootRun` (Windows)</li>
3. Wait until the terminal output displays the "Started Application in xxx seconds" message.
4. Your app should be up now in http://localhost:8080/ 
5. The oauth2 callback endpoint in the sample app is http://localhost:8080/oauth2redirect
6. To run the code on a different port, uncomment and update server.port property in application.properties

## Storing the tokens
This app stores all the tokens and user information in the session. For production ready app, tokens should be encrypted and stored in a database.

## Appendix

### All Review Board Resources

```
Ability to perform HTTP GET on the change resource
Ability to perform HTTP GET on the file_attachment_comment resource
Ability to perform HTTP POST on the hosting_service_account resource
Ability to perform HTTP POST on the diff_validation resource
Ability to perform HTTP DELETE on the webhook resource
Ability to perform HTTP DELETE on the repository resource
Ability to perform HTTP GET on the group resource
Ability to perform HTTP POST on the user resource
Ability to perform HTTP DELETE on the review_request resource
Ability to perform HTTP GET on the screenshot resource
Ability to perform HTTP GET on the review_group_user resource
Ability to perform HTTP PUT, POST on the user_file_attachment resource
Ability to perform HTTP POST on the review_group_user resource
Ability to perform HTTP GET on the user_file_attachment resource
Ability to perform HTTP DELETE on the oauth_app resource
Ability to perform HTTP PUT, POST on the file_attachment resource
Ability to perform HTTP PUT on the draft_file resource
Ability to perform HTTP PUT, POST on the screenshot_comment resource
Ability to perform HTTP GET on the diff resource
Ability to perform HTTP PUT, POST on the review resource
Ability to perform HTTP GET on the diff_comment resource
Ability to perform HTTP DELETE on the user_file_attachment resource
Ability to perform HTTP DELETE on the review_group_user resource
Ability to perform HTTP DELETE on the screenshot resource
Ability to perform HTTP POST on the watched_review_group resource
Ability to perform HTTP GET on the reply resource
Ability to perform HTTP DELETE on the screenshot_comment resource
Ability to perform HTTP PUT, POST on the general_comment resource
Ability to perform HTTP GET on the diff_file_attachment resource
Ability to perform HTTP PUT, POST on the file_attachment_comment resource
Ability to perform HTTP GET on the file_attachment_comment resource
Ability to perform HTTP GET on the file_attachment_comment resource
Ability to perform HTTP PUT, POST on the draft_file_attachment resource
Ability to perform HTTP GET on the hosting_service_account resource
Ability to perform HTTP PUT, POST on the review_request resource
Ability to perform HTTP DELETE on the file_attachment_comment resource
Ability to perform HTTP DELETE on the general_comment resource
Ability to perform HTTP PUT, POST on the diff_comment resource
Ability to perform HTTP PUT, POST on the diff resource
Ability to perform HTTP GET on the watched_review_request resource
Ability to perform HTTP GET on the screenshot_comment resource
Ability to perform HTTP PUT, POST on the repository resource
Ability to perform HTTP GET on the draft_diff resource
Ability to perform HTTP PUT on the extension resource
Ability to perform HTTP GET on the commits resource
Ability to perform HTTP GET on the reply_draft resource
Ability to perform HTTP GET on the patched_file resource
Ability to perform HTTP GET on the file resource
Ability to perform HTTP GET on the draft_screenshot resource
Ability to perform HTTP GET on the diff_comment resource
Ability to perform HTTP DELETE on the watched_review_request resource
Ability to perform HTTP GET on the screenshot_comment resource
Ability to perform HTTP PUT, POST on the oauth_app resource
Ability to perform HTTP PUT, POST on the default_reviewer resource
Ability to perform HTTP GET on the branches resource
Ability to perform HTTP GET on the extension resource
Ability to perform HTTP GET on the review_request resource
Ability to perform HTTP DELETE on the reply resource
Ability to perform HTTP GET on the screenshot_comment resource
Ability to perform HTTP DELETE on the archived_review_request resource
Ability to perform HTTP DELETE on the diff_comment resource
Ability to perform HTTP GET on the original_file resource
Ability to perform HTTP GET on the oauth_app resource
Ability to perform HTTP GET on the draft_file_attachment resource
Ability to perform HTTP DELETE on the draft_screenshot resource
Ability to perform HTTP GET on the draft resource
Ability to perform HTTP GET on the session resource
Ability to perform HTTP DELETE on the file_attachment resource
Ability to perform HTTP DELETE on the status_update resource
Ability to perform HTTP GET on the user resource
Ability to perform HTTP DELETE on the group resource
Ability to perform HTTP GET on the remote_repository resource
Ability to perform HTTP PUT, POST on the file_attachment_comment resource
Ability to perform HTTP DELETE on the general_comment resource
Ability to perform HTTP GET on the watched_review_group resource
Ability to perform HTTP DELETE on the muted_review_request resource
Ability to perform HTTP GET on the draft_original_file resource
Ability to perform HTTP DELETE on the draft resource
Ability to perform HTTP POST on the muted_review_request resource
Ability to perform HTTP PUT, POST on the screenshot_comment resource
Ability to perform HTTP DELETE on the session resource
Ability to perform HTTP POST on the archived_review_request resource
Ability to perform HTTP GET on the webhook resource
Ability to perform HTTP PUT, POST on the draft_diff resource
Ability to perform HTTP DELETE on the review resource
Ability to perform HTTP POST on the watched_review_request resource
Ability to perform HTTP DELETE on the file_attachment_comment resource
Ability to perform HTTP PUT, POST on the draft_screenshot resource
Ability to perform HTTP GET on the validation resource
Ability to perform HTTP GET on the search resource
Ability to perform HTTP PUT, POST on the reply resource
Ability to perform HTTP GET on the info resource
Ability to perform HTTP GET on the status_update resource
Ability to perform HTTP GET on the file_attachment resource
Ability to perform HTTP PUT, POST on the general_comment resource
Ability to perform HTTP DELETE on the default_reviewer resource
Ability to perform HTTP GET on the last_update resource
Ability to perform HTTP GET on the draft_file resource
Ability to perform HTTP GET on the diff_comment resource
Ability to perform HTTP DELETE on the screenshot_comment resource
Ability to perform HTTP GET on the root resource
Ability to perform HTTP GET on the default_reviewer resource
Ability to perform HTTP GET on the info resource
Ability to perform HTTP DELETE on the draft_file_attachment resource
Ability to perform HTTP GET on the review resource
Ability to perform HTTP PUT, POST on the status_update resource
Ability to perform HTTP PUT on the file resource
Ability to perform HTTP PUT, POST on the screenshot resource
Ability to perform HTTP GET on the general_comment resource
Ability to perform HTTP PUT, POST on the diff_comment resource
Ability to perform HTTP GET on the watched resource
Ability to perform HTTP GET on the draft_patched_file resource
Ability to perform HTTP PUT, POST on the webhook resource
Ability to perform HTTP GET on the repository resource
Ability to perform HTTP GET on the review_draft resource
Ability to perform HTTP GET on the diff_context resource
Ability to perform HTTP GET on the diff_validation resource
Ability to perform HTTP PUT, POST on the draft resource
Ability to perform HTTP GET on the hosting_service resource
Ability to perform HTTP PUT, POST on the group resource
Ability to perform HTTP GET on the general_comment resource
Ability to perform HTTP DELETE on the diff_comment resource
Ability to perform HTTP DELETE on the watched_review_group resource
```
