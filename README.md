# add-resource
sample for adding resource dynamically

テストデータを動的に読み込むための検証プロジェクト

## 目的

* データは通常`src/main/resource`, `src/test/resources` に格納してあるが、固定で置きたくいケースを考えた。
* その場合に `mvn` のコマンド実行時に動的に読み込めるかを検証しているプロジェクトである.

## 概要

* `App#map(String)` を実行すると、クラスパス内から引数のファイルパスを読み込み（csv形式）、key-value形式に変換する
* 詳細は`AppTest` クラスを参照。
* しかし、このプロジェクトには `src/main/resources`, `src/test/resources` の両方存在しない
* `mvn` コマンド実行時に `-Dsample.dir=pom.xmlファイルからの相対パス` を付与すると、そのディレクトリがリソースとして追加されて動作する。
