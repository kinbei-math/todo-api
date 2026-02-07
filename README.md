# Todo API Project

Spring Boot学習用のTodo管理アプリケーション（バックエンド）です。
レイヤードアーキテクチャ（Controller / Service / Repository）を採用し、REST APIの構築を行っています。

## 🚀 環境 / 技術スタック
- **Java**: 25
- **Framework**: Spring Boot 4.0.2
- **Build Tool**: Gradle
- **API Test**: Postman / curl

### 12. Spring Bootプロジェクト作成と環境構築
- **日付**: 2/3
- **ファイル**: [build.gradle](build.gradle), [TodoApiApplication.java](src/main/java/com/example/todo_api/TodoApiApplication.java)
- **学習内容**:
  - Spring Initializrを使ったプロジェクト生成（Web, Gradle, Java 21）
  - `@SpringBootApplication` によるアプリ起動とTomcat（8080ポート）の確認
  - Spring Bootにおけるディレクトリ構成のルール（メインクラス配下に配置）
- **メモ**: パッケージ作成時、親フォルダを選択し忘れると階層が外れてスキャンされないため、必ずメインパッケージの内側に作成する。

### 13. レイヤードアーキテクチャとREST API構築
- **日付**: 2/3
- **ファイル**: [controller/TodoController.java](src/main/java/com/example/todo_api/controller/TodoController.java), [form/TodoCreateForm.java](src/main/java/com/example/todo_api/form/TodoCreateForm.java)
- **学習内容**:
  - 3層構造（Controller/Service/Repository）の役割分担
  - `@RestController` と `@PostMapping` を使ったWeb APIのエンドポイント作成
  - `@RequestBody` を使ったJSONデータの受け取り
  - DTO（データ転送用オブジェクト）としての `record` の活用（Java 21新機能）

### 14. 依存性の注入（DI）と動作確認
- **日付**: 2/3
- **ファイル**: [service/TodoService.java](src/main/java/com/example/todo_api/service/TodoService.java), [repository/TodoRepository.java](src/main/java/com/example/todo_api/repository/TodoRepository.java)
- **学習内容**:
  - `@Service`, `@Repository` アノテーションによるBean化
  - コンストラクタインジェクションによるDI（依存性の注入）の実装
  - クラス間の結合度を下げる（疎結合）設計思想の理解
  - Postmanを使用したAPIへのPOSTリクエスト送信とログ確認（Controller → Service → Repositoryの連携確認）

### 15. Spring Bootのレイヤーアーキテクチャ
- **日付**:2/4
- **ファイル**:[entity/Todo.java](src/main/java/com/example/todo_api/entity/Todo.java),[repository/TodoRepository.java](src/main/java/com/example/todo_api/repository/TodoRepository.java),[service/TodoService.java](src/main/java/com/example/todo_api/service/TodoService.java),[controller/TodoController.java](src/main/java/com/example/todo_api/controller/TodoController.java),[build.gradle](build.gradle)
- **学習内容**:
  - Controller (受付): リクエストを受け取り、Serviceへ依頼。
  - Service (実務): データの加工やビジネスロジックを担当。
  - Repository (倉庫): データベースへの保存・取得（Spring Data JPA利用）。
  - Entity (箱): データの構造定義とID自動採番（`@GeneratedValue`）。

### 16. トラブルシューティング
- **日付**:2/4
- **ファイル**:[entity/Todo.java](src/main/java/com/example/todo_api/entity/Todo.java),[repository/TodoRepository.java](src/main/java/com/example/todo_api/repository/TodoRepository.java),[service/TodoService.java](src/main/java/com/example/todo_api/service/TodoService.java),[controller/TodoController.java](src/main/java/com/example/todo_api/controller/TodoController.java),[build.gradle](build.gradle)
- **学習内容**:
  - H2 Consoleが表示されない問題（404 Not Found）に直面。
  - `build.gradle` の依存関係（`spring-boot-starter-web`）の修正を実施。
  - 次回、IDEのキャッシュを排除した起動方法（`./gradlew bootRun`）で解決確認予定。

### 17. API結合テストの実装と型安全性の担保
- **日付**: 2/5
- **ファイル**:[controller/TodoController.java](src/main/java/com/example/todo_api/controller/TodoController.java),[form/TodoCreateForm.java](src/main/java/com/example/todo_api/form/TodoCreateForm.java),[repository/TodoResponse.java](src/main/java/com/example/todo_api/repository/TodoRepository.java),[todo_api/TodoControllerTest.java](src/test/java/com/example/todo_api/TodoControllerTest.java)
- **学習内容**:
  - @WebMvcTest + MockMvc による Web層限定の軽量テストを実装（Controllerの入出力と責務を検証）
  - LocalDate.parse() を用いた ISO 8601（YYYY-MM-DD）→ LocalDate の型変換を確認
  - jsonPath で レスポンスJSONの値（title / dueDate） を検証し、型安全性と整合性を担保
  - Mockito.verify による Controller → Service 呼び出し（引数/回数） の検証で委譲の正しさを証明
  - メモ：@MockitoBean の戻り値はデフォルトで null になりやすい。テスト側で戻り値を定義（stub）するか、Controller側のレスポンス生成方針を調整する必要がある

  ---
Last Updated: 2026/02/06
