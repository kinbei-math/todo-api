# Todo API Project

Spring Boot学習用のTodo管理アプリケーション（バックエンド）です。
レイヤードアーキテクチャ（Controller / Service / Repository）を採用し、REST APIの構築を行っています。

## 🚀 環境 / 技術スタック
- **Java**: 25
- **Framework**: Spring Boot 4.0.2
- **Build Tool**: Gradle
- **API Test**: Postman / curl

12. Spring Bootプロジェクト作成と環境構築
日付: 2/3

ファイル: build.gradle, TodoApiApplication.java

学習内容:

Spring Initializrを使ったプロジェクト生成（Web, Gradle, Java 21）

@SpringBootApplication によるアプリ起動とTomcat（8080ポート）の確認

Spring Bootにおけるディレクトリ構成のルール（メインクラス配下に配置）

メモ: パッケージ作成時、親フォルダを選択し忘れると階層が外れてスキャンされないため、必ずメインパッケージの内側に作成する。

13. レイヤードアーキテクチャとREST API構築
日付: 2/3

ファイル: controller/TodoController.java, form/TodoCreateForm.java

学習内容:

3層構造（Controller/Service/Repository）の役割分担

@RestController と @PostMapping を使ったWeb APIのエンドポイント作成

@RequestBody を使ったJSONデータの受け取り

DTO（データ転送用オブジェクト）としての record の活用（Java 21新機能）

14. 依存性の注入（DI）と動作確認
日付: 2/3

ファイル: service/TodoService.java, repository/TodoRepository.java

学習内容:

@Service, @Repository アノテーションによるBean化

コンストラクタインジェクションによるDI（依存性の注入）の実装

クラス間の結合度を下げる（疎結合）設計思想の理解

Postmanを使用したAPIへのPOSTリクエスト送信とログ確認（Controller → Service → Repositoryの連携確認）