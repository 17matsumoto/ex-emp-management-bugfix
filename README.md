# ex-emp-management-bugfix
このプロジェクトは従業員を管理するプロジェクトです。


## システム概要
* 管理者登録認証: 管理者はアカウントを作成し、ログインすることができます。
* 従業員一覧表示: 管理者は従業員を閲覧することができます。
* 従業員情報: 管理者は従業員の詳細から扶養人数を更新することができます。
* 従業員登録: 管理者は従業員情報を新規登録することができます。
## 必要なソフトウェアとライブラリー
* 言語:　Java17, SQL, HTML, CSS
* フレームワーク:　SpringBoot(Spring MVC, Spring JDBC, Spring Security), Thymeleaf
* その他ツール:　PostgreSQL15, Tomcat8, Git, Maven, Eclipse(STS), Ajax, JSON, JUnit, Tera Term
## インストールとセットアップ
1. プロジェクトをクローンする :　git clone https://github.com/17matsumoto/ex-emp-management-bugfix.git
2. データベースを作成する。: Postgresqlで新しいデータベースを作成し、接続情報を設定します。
3. データベースの設定を更新する: src/main/resources/application.yml ファイル内のデータベース接続情報を更新します。
4. プロジェクトを更新する: gradleを更新します。
5. アプリケーションを実行する: spring boot　Appを実行します。
6. ブラウザでアプリケーションにアクセスします: http://localhost:8080

## 使用方法
1. アカウントの作成: サイトにアクセスし、新しいアカウントを作成します。
2. ログイン: 作成したアカウントでログインします。
3. 従業員一覧: 従業員を選択して閲覧します。扶養人　登録し「更新」ボタンを押す。
4. 従業員登録: 「従業員登録」ボタンを押し、従業員の情報を入力し「登録」ボタンを押す。

