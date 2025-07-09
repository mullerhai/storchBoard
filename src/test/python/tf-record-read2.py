import tfrecord
import numpy as np

# 定义数据生成函数
def generate_dummy_data():
    """生成模拟数据。"""
    num_samples = 10
    for _ in range(num_samples):
        features = {
            'image': np.random.randint(0, 256, size=(32, 32, 3), dtype=np.uint8),
            'label': np.random.randint(0, 10, dtype=np.int64)
        }
        yield features

# 定义特征描述
description = {
    'image': 'byte',
    'label': 'int'
}

# 创建 TFRecord 文件
def create_tfrecord_file(file_path):
    """创建 TFRecord 文件。"""
    writer = tfrecord.TFRecordWriter(file_path)
    for features in generate_dummy_data():
        writer.write({
            'image': features['image'].tobytes(),
            'label': features['label']
        })
    writer.close()

# 读取并解析 TFRecord 文件
def read_tfrecord_file(file_path):
    """读取并解析 TFRecord 文件。"""
    loader = tfrecord.tfrecord_loader(file_path, None, description)
    print(loader)
    for record in loader:
        print(record)
        print(len(record.keys()))
        # print(record.keys())
        # image = np.frombuffer(record['image'], dtype=np.uint8).reshape(32, 32, 3)
        # label = record['label']
        # print(f"Image shape: {image.shape}, Label: {label}")

if __name__ == "__main__":
    # 创建 TFRecord 文件
    # tfrecord_file_path = "example.tfrecord"
    # create_tfrecord_file(tfrecord_file_path)

    tfevent_file_path = "D:\\data\\git\\storchBoard\\logz\\train29.tfevents"
    # 读取并解析 TFRecord 文件
    read_tfrecord_file(tfevent_file_path)
