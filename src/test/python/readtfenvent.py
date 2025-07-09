from tensorboard.backend.event_processing.event_accumulator import EventAccumulator

def read_tfevent_file(file_path):
    # 初始化 EventAccumulator 对象
    event_accumulator = EventAccumulator(file_path)
    # 加载事件数据
    event_accumulator.Reload()

    # 获取所有可用的标签
    tags = event_accumulator.Tags()
    print("可用的标签:", tags)

    # 遍历所有标量数据
    if 'scalars' in tags:
        for tag in tags['scalars']:
            events = event_accumulator.Scalars(tag)
            print(f"标签: {tag}")
            for event in events:
                print(f" scalars 步数: {event.step}, 时间戳: {event.wall_time}, 值: {event.value}")

    if 'tensors' in tags:
        for tag in tags['tensors']:
            events = event_accumulator.Tensors(tag)
            print(f"标签: {tag}")
            for event in events:
                print(f" Tensors 步数: {event.step}, 时间戳: {event.wall_time}, 值: {event.tensor_proto.dtype}, 形状: {event.tensor_proto.tensor_shape.dim}")

    # 遍历所有图像数据
    if 'images' in tags:
        for tag in tags['images']:
            images = event_accumulator.Images(tag)
            print(f"标签: {tag}")
            for image in images:
                print(f"images  步数: {image.step}, 时间戳: {image.wall_time}, 图像大小: {image.width}x{image.height}")

    # 遍历所有音频数据
    if 'audio' in tags:
        for tag in tags['audio']:
            audios = event_accumulator.Audio(tag)
            print(f"标签: {tag}")
            for audio in audios:
                print(f"audio  步数: {audio.step}, 时间戳: {audio.wall_time}, 音频长度: {audio.length_frames}")

    # 遍历所有直方图数据
    if 'histograms' in tags:
        for tag in tags['histograms']:
            histograms = event_accumulator.Histograms(tag)
            print(f"标签: {tag}")
            for histogram in histograms:
                print(f"hist  步数: {histogram.step}, 时间戳: {histogram.wall_time}")

    # 遍历所有计算图数据
    # if 'graph' in tags:
    #     graph = event_accumulator.Graph()
    #     print("计算图数据已加载")

    # 遍历所有元图数据
    # if 'meta_graph' in tags:
    #     meta_graph = event_accumulator.MetaGraph()
    #     print("元图数据已加载")

    # 遍历所有运行时设备数据
    if 'run_metadata' in tags:
        for tag in tags['run_metadata']:
            run_metadata = event_accumulator.RunMetadata(tag)
            print(f"运行时设备数据: {tag} 已加载")

if __name__ == "__main__":
    # 替换为你的 tfevent 文件路径
    # tfevent_file_path = "D:\\code\\data\\llm\\手撕LLM速成班-试听课-小冬瓜AIGC-20231211\\data\\simulated_training\\train-2r2.tfevents"
    tfevent_file_path = "D:\code\data\llm\手撕LLM速成班-试听课-小冬瓜AIGC-20231211\data\simulated_training\events.out.tfevents.1752044373.TinyMice.46896.0"
    read_tfevent_file(tfevent_file_path)
