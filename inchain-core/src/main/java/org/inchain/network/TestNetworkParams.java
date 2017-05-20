package org.inchain.network;

import java.net.InetSocketAddress;

import org.inchain.Configure;
import org.inchain.crypto.Sha256Hash;
import org.inchain.message.DefaultMessageSerializer;
import org.inchain.message.MessageSerializer;
import org.inchain.store.BlockStore;
import org.inchain.utils.Hex;
import org.inchain.utils.Utils;

/**
 * 测试网络
 * @author ln
 *
 */
public class TestNetworkParams extends NetworkParams {
	
    public TestNetworkParams() {
    	seedManager = new RemoteSeedManager();

    	seedManager.addDnsSeed("test1.seed.inchain.org");
    	seedManager.addDnsSeed("test2.seed.inchain.org");
    	
    	seedManager.add(new Seed(new InetSocketAddress("47.93.16.125", Configure.DEFAULT_PORT)));
    	seedManager.add(new Seed(new InetSocketAddress("119.23.249.26", Configure.DEFAULT_PORT)));
    	seedManager.add(new Seed(new InetSocketAddress("119.23.253.3", Configure.DEFAULT_PORT)));
    	seedManager.add(new Seed(new InetSocketAddress("119.23.254.99", Configure.DEFAULT_PORT)));
		
    	init();
	}
    

	public TestNetworkParams(SeedManager seedManager) {
    	this.seedManager = seedManager;
    	init();
	}
    
	private void init() {
		
		id = ID_TESTNET;
		
		packetMagic = 629166548l;
		
		this.acceptableAddressCodes = new int[] {getSystemAccountVersion(), getCertAccountVersion()};
	}
	
	/**
	 * 测试网络的创世块
	 */
	@Override
	public BlockStore getGengsisBlock() {
		BlockStore gengsisBlock = new BlockStore(this, Hex.decode("000000000000000000000000000000000000000000000000000000000000000000000000f674d775c1cf78a65b52ca0df6fc92c2fbdf9a6c2a51b8b5a66b494b269bd96b61a3db5800000000000061a3db58822102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f3098846304402202e98d0ea362d2bcddc73b2f1ae656bffc22db26f83005ef9569f34adfb1ad7f90220598a4e840caeba243a64eaa0b5b05cbdbaaf015b82e99bf773d8fc9903617e9aac140101000000010012117468697320612067656e6773697320747800000000010080faca73f91f0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688acc135f6195b010000000000000000000000020100000001015debba54e85a646687c0f519bb9a8f8f08f45feef0523807650a6e7d02273ea3000000006a47304402201657b9f113fe690f1f275d00e215800ad4bd136323cedccded93a9c7b8d879df02206817c61e473694b81e560b38b8b4f862615d515b152a7a92f984e14fc89d975001210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020080c6a47e8d0300004c11f1640100001976a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988ac00003426f56b1c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac0036f6195b01000000000000000000000006010000000e36f6195b010000832102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988473045022100b37982c275af2958697a3cca4b1136c16190189d2385412703a3c4949c03cd3202206878a7613e4f93f4eb9c8104c971f77f066643d087001ae31e371bd8d4889fe0ac4237cccf6ff9a7674a8fc47c60278fdd23e9f3097f9698000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101e074de856deafbc533266ef22f9c8a82000a40a9bfe352335f708810a392e220010000006b48304502210085a55f21c1d37e5bf45895299943557288c689d2479d71c3ed82f434373b88b202200d1b31db2e7f74ffd86ad53c0a23ab8816678371c5bca497adadb495c10b8f1e01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e800000000000000000000001976a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988ac00f08e510c6b1c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac0f36f6195b010000000000000000000000030100000000001036f6195b010000000000000000000000832102883a9625a871e79c070e316edafc97eac2f6c97b218d0e55726f25be2a963e9276a9144237cccf6ff9a7674a8fc47c60278fdd23e9f30988473045022100839211bdeebea5720d1b55e3c73e173c2c135141b86c83e8d9caa7b3bf3116c8022061d0d54acbae482cbbcf2771875fbe1937da3c47eb57a20f047ed6653ab908e0ac8836f61906010000002936f6195b010000822103a7db4a854e3f2ae3a30aa759bfd39045f6a80c967b3fd81036acebc54b557ece76a9142c1179b1e05fb8652644f6c61a033d28431009128846304402207dc8276e6cf39cb1492d4452ced63ace131778d2adfff0124bb6b31d9c3abbdb02206da89460696b24f5ceb7e2f6517e2375b8c8c67a5b253f5bbd4086250a69f45aac2c1179b1e05fb8652644f6c61a033d28431009127f9698000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101fac77dd96045c9570d103da31cb0752e9345a6c4afae8e848b2ffbdbaa195e38010000006b483045022100df96c12d09205d053803149552138ee28b2718063809b5e057c135ec17bdcb4202202bb699108d9029b29edfef55a0c66d1424b08ffa95bcf73f6b216d4a6d95f29d01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e800000000000000000000001976a9142c1179b1e05fb8652644f6c61a033d284310091288ac00e0e97c236a1c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac2a36f6195b010000000000000000000000030100000000002a36f6195b010000000000000000000000832103a7db4a854e3f2ae3a30aa759bfd39045f6a80c967b3fd81036acebc54b557ece76a9142c1179b1e05fb8652644f6c61a033d284310091288473045022100ac23eb82766b831349bdbcf6be997b7373e6271dca9454edeb1d48a0ca6dfe7d02200d9853c73fb8f1f8e2fc112a03fe2a821e8c54afbec47e8bd89ca45a97a3d165aca236f61906010000002d36f6195b0100008321033e371b2f3d42dd525833bcce12cb0d404fb73898bdea3e6794bd8ec552c9ba9c76a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c88473045022100d87d83ee8967506b4776d84a907e43689cbe92075120d1889bc09f2d7052edb102202486a73e3818a3a3ab0b9c5399750da4ef1070d5470503829ad254ecb32fe4e0acb3fcd687a5c2b2617de0d504cfa7d12db93bb00c7f96980000000000000000000000000000000000000000000000000000000000000000000000000000020100000001015919fe3cbef78732b071315b27d7dce5eb5689887dd11efad864b0e3e6528ed4010000006b483045022100e93ff0a535bbad225ca1aabd5f0204fd82d7e83568eeed16173e7011c8db877f02205237c7796303ffcfeab7bd8e5b5d365d7d945a22cd49df22d40e28e60213723e01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e800000000000000000000001976a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c88ac00d044a83a691c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac2d36f6195b010000000000000000000000030100000000002e36f6195b0100000000000000000000008321033e371b2f3d42dd525833bcce12cb0d404fb73898bdea3e6794bd8ec552c9ba9c76a914b3fcd687a5c2b2617de0d504cfa7d12db93bb00c88473045022100c5ef29a5d5a425c1cd07bbe1d2076a45b69a8d0991203ae6884e5cf5b654773302207503f61880d7291709c34032bdc9985ccf1be968c4088e6011b86e8db3565a87aca636f61906010000003136f6195b010000822103bf7759e9b81f8ff1b99732b3ee36aea0abff68c818b8839c318ad350e9642cb076a914c3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a888463044022031e464610d260e8f2bf2c43580dad6cd3795d002563579603548fc89f80bebd202206ec9cdba7edfbbefa07e99afc1fe2a9c6bacf7c1d2b4b7a519de19305e29a41eacc3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a87f969800000000000000000000000000000000000000000000000000000000000000000000000000000201000000010127f48a5035290cb328bcfb8b7173ea285264a9677d6df0e23c28acbdc6db8d22010000006b483045022100a9fb4c6d19a22eb688ad0daf2fa01e4baf043814238ab323af9a7009697a00b202204e96b80afbd5cec6bc6e90d33fd567c8f25e170dcc232d6804ee0f37faa9c11b01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e800000000000000000000001976a914c3bfdb8a67f35b6e4ea1ee3ae7b91eff58ec81a888ac00c09fd351681c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac3136f6195b01000000000000000000000006010000003336f6195b01000083210200d482122f8537ad2fa1af1914e088d6b308824a8ef4dc8b68fa0e0a88c484e376a9145f1a078b610d92a3110b2c1a7f880b0d2442e53088473045022100a00bbb9d88b59b75a8c61231eb702431d79aecad3956a6af12f3515e82dc2f0302203d20d37d3ab6b3073baae5797de1a022c9e495279cadbeaed5a321b5b2fc40a8ac5f1a078b610d92a3110b2c1a7f880b0d2442e5307f969800000000000000000000000000000000000000000000000000000000000000000000000000000201000000010112eb53c18a0a73fe2ad0da323c8568a25c1e9faeacae9c85a1cace64fac275c3010000006b483045022100bd1886f305e03139cfbb368e6b358e92e913e88442639a5005c62b438a03eaed02202dbad836ae0a5d1968513197fe3a866356a1ba11fb1eefb2fe2bdeab9256897901210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e800000000000000000000001976a9145f1a078b610d92a3110b2c1a7f880b0d2442e53088ac00b0fafe68671c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac3336f6195b01000000000000000000000006010000003536f6195b010000822103e8769d1901a4ef006054405c16716d6648fffe628385db5586c7fa18c3df5da876a914df639c6066a817a6be28b532839f8e1e85594cd488463044022066a56056d6e5568b2986f61fb7d3a2a309d5856160c971499dc49d47d5ab10f2022068f06c4d3043e698b0e4434f9b3b6a77a15a1ed4daa189fa9ee59dd296ba1f24acdf639c6066a817a6be28b532839f8e1e85594cd47f969800000000000000000000000000000000000000000000000000000000000000000000000000000201000000010183c40df19daaba7c1b48d94dac3edf3122d7a64af6bba7fb3bfb000cddbb4aff010000006b4830450221009bad24b1abb81bf5e08439a0dd25886a8fdb62fcae971e2aa647a7d3e2937cee0220719a8bc124ec486c11f45b3b43d0479ed2d46374dfcfa436c4bb258ea9674f4f01210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e800000000000000000000001976a914df639c6066a817a6be28b532839f8e1e85594cd488ac00a0552a80661c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac3536f6195b01000000000000000000000006010000003736f6195b010000832103368f8061e02694e37da199c07c3e2f2506cdd748efee493f0d1c52ae7494428f76a914e3453a80144f6ac24baf01f20455c6167b98548588473045022100ddec9c253411423a284bbdba86373dbfc52d6beb31419ec55479e8d9151156d402201062f2170db3f142c1fce5fde9e1b8af07b1c8a7e4da06099498f6c53e0dfd14ace3453a80144f6ac24baf01f20455c6167b9854857f9698000000000000000000000000000000000000000000000000000000000000000000000000000002010000000101f59b0cd79d2076de391cbd2ef5805cab5fcf50b360aebd6c3a85b2d6bcec1a3b010000006b483045022100955f04410c7f3bd8d5e7070b98b01145ca49a350a3b0b02af3c90f46a51fb7af02205c55f377ba50485b1cc7f3d7cc792d15301d5861cb66bf46f58f326bc156f03201210276c52ff14acd4c4d3e08f9596e0127a15e98207b3d0024426364825cd724c86dffffffff020010a5d4e800000000000000000000001976a914e3453a80144f6ac24baf01f20455c6167b98548588ac0090b05597651c0000000000000000001976a914bb7e4d6ffb3266a0b533b21847bef4dacce95f4688ac3736f6195b0100000000000000000000000b01000000d1d44afc5a010000d4f493c62957ca4916962178881af76ce6c74308fd070e2b046e616d6506e5908de7a7b01ee9878de5ba86e58db0e993bee7a791e68a80e69c89e99990e585ace58fb822076164647265737306e59cb0e59d8012e9878de5ba86e5b882e58d97e5b2b8e58cbafd260c046c6f676f06e59bbee78987fd170c89504e470d0a1a0a0000000d4948445200000050000000500803000000b9cf029f0000001974455874536f6674776172650041646f626520496d616765526561647971c9653c0000038869545874584d4c3a636f6d2e61646f62652e786d7000000000003c3f787061636b657420626567696e3d22efbbbf222069643d2257354d304d7043656869487a7265537a4e54637a6b633964223f3e203c783a786d706d65746120786d6c6e733a783d2261646f62653a6e733a6d6574612f2220783a786d70746b3d2241646f626520584d5020436f726520352e362d633133382037392e3135393832342c20323031362f30392f31342d30313a30393a30312020202020202020223e203c7264663a52444620786d6c6e733a7264663d22687474703a2f2f7777772e77332e6f72672f313939392f30322f32322d7264662d73796e7461782d6e7323223e203c7264663a4465736372697074696f6e207264663a61626f75743d222220786d6c6e733a786d704d4d3d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f6d6d2f2220786d6c6e733a73745265663d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f73547970652f5265736f75726365526566232220786d6c6e733a786d703d22687474703a2f2f6e732e61646f62652e636f6d2f7861702f312e302f2220786d704d4d3a4f726967696e616c446f63756d656e7449443d22786d702e6469643a63366435353139652d333762642d343630662d613136662d6263623131316565396535652220786d704d4d3a446f63756d656e7449443d22786d702e6469643a42333641414136314544434131314536394142353936384532413336433538422220786d704d4d3a496e7374616e636549443d22786d702e6969643a42333641414136304544434131314536394142353936384532413336433538422220786d703a43726561746f72546f6f6c3d2241646f62652050686f746f73686f7020434320323031352e3520284d6163696e746f736829223e203c786d704d4d3a4465726976656446726f6d2073745265663a696e7374616e636549443d22786d702e6969643a31663063653734362d373938392d616634662d396362342d393233623361313333346635222073745265663a646f63756d656e7449443d2261646f62653a646f6369643a70686f746f73686f703a36363933666334302d656463372d313165362d626534372d613738373163636365383764222f3e203c2f7264663a4465736372697074696f6e3e203c2f7264663a5244463e203c2f783a786d706d6574613e203c3f787061636b657420656e643d2272223f3ebee777fb00000180504c5445f75d4ff97c4bfa854af9794bfca546f7614ef8797cfcad6efee3d9fda946feeeeefcbca9f65150f54552f44152f54d51f43d53f65a4ffef2ecf54951f8796bfeebe3f43a53fca253fdcbbbfa9587fdd6c8f8827dfff4edfcab4ffdd9d6f76862f86a4df65450fb9848fbac99fdad45f98a88f66259f9897bfb9a47fa8e49f8764cf87a56fb9049f65c5afb9b51fcb499fcc2adf9804afa9352f8704cf87456f54c5bfb9548f86d4df5435cfa8b49fcb282f8744cf86f4df7684dfb9348f8724cfa8c49fc9e47fca346fb9248fc9c47fca047f7644ef6535afa8b54fcab83f7664ef98454f33254f76b57fb976afdcaacfdd6bcf33653f65964f43d5dfef0edfee6e1f9886bfa834afdb14efba18bf76b58fef1e5f33454fba584f97b5cfa9b74fdcba3feeeeafa884af9949cf76672f98574f9784cf76f57f76758fa8d74f87061fef0ebfee5cffa9059fa8949fef1edf6574ff9824af7674efb9b47f33753fca74ff65d53fba890f5485bfcc2bef97f4bf98f92f8754ffef0eefeefeefef2edae422d56000006994944415478daacd9f95f53391000f007ae50db0a54a88502dd96ca2550caa51cbaae2887a2dc15590456141094431716656dfbaf3b33495e32e92badbb3bbff7fb4932c964f2eabc36a3f575ab8c7388c8790422154989184c0d521ccd52cc89e899eba118c6d87fb9e5dc31e206c62f1893939353538f1f3f7efa575757575bdbbd7bbf3d79d2dbddddfdfbd8d8f14e6565e5dae781cbcb8a8a8abdbdbdbb13138f86861edcbf1f8f3ffcf27cda79adb93b051e826de801d8db2bbd1df206d0bb766def2e80ca7bf865faa50992774380a5bd4bd77b84de7df49e1be00d36e1293561e54990bc4aeded698f266c8ed07b01b937b6632e207a77d9029aa097e731e1e2de43f4ae7f50a05ec07f9f10f014682fa087d77d6542c484af6bd033215d5e0959b31232c43cc7044b25e4b8544234e8e13d2d9a9081a20901cfe900b08c052c2f21e009909f10af1d3d567a470b2fa4c1ab1332564642000c21582c216d3f9d100334bcf3c58d4fd5e4a516c2e18db07764c29958e0959510f04e05689698c59696968d088e6fa185475ec70945f6dbb02831aee7827a01a736f0b7e3b880e1a2e0898c7c6ccbf2006cb512f2097f5b8d09f19518200c311b351302de691f80bc4657c310ffbc87315edacb66d7cd053c3d4d00689598a791f188dc31d50b6ea417d23a02e94020d098412f1bbb6e4e3841a07542ba0a4fc8da67d8d103468979001b663846e221f31458aae67beee8750277b5076050806c47a7aa23d68e9eef5ff4853732d1c0fc3573473711d8692c6022284056622829a6b719d529f125f7f40991a0a33d0d1a2586b64dc4f58e1659826fc50e9417d7a05ac0603038e3b44ef205a43d32ae6afe7cc6dad1f9b7ebaac41098eb645e6d1f82acc4b82024e4783e5cb80357d76549403007a09b1004679c73abc408504cf8c827bd68e0e2a2bff1add8cf1f0f448969428f40b580b5b504f29a2f41f48e1bc9bb159d17356b2bf0910e886f9f4a8c04b52741abe60b9012b22dc6d70ffb4feee8ed0cce3a9ba492d0849e005dcf05f58e5620ec68ac64f9967ebda387860edee211ceec634968ca09d0f408e4274e8058f38ff238c0283f21fdb4579a9ec309166073482684bc7a00ad9a2f41d8d1e334e16d5ef387a9267c9bd6a04e08780046ac4b53803b708417d0f3d997661a411f964005ea09d74b905dc2043ec3921045306d7731e27c7c00b05d80c6024a909718094289f99497296697f0ae2a5a4e93020daf7ec4895897b000b164f924c82ecd7883041d8746e86f36bd9b085a6da502d73e0bd0ee6208cc1d4249c011fa0974c777f32682bc8b9120146905b22e26ee82a176f4fccd3a21e021682c2096180942cd17a0ddc534504938848ae082b505a059f30508355f81bc8bc129e714e827d0f46a469c94d5150910bb1801da5d4c039d60004fdbb30432cf00558d1620de7112b4da4a01fe0a07aeddef82ae4720bf34e9527f86771c8149b98071d5c534e40a41e949d0ba3469849b0668b5951284132cc02a36c09aaf08b2b6926ae0269618044f9213565be98e5083864720bf84a9c46c5608f0249fb4db4a35c284007355cc93a0d997d31db28925c187d53969f7e5124c24dc114a8fc43a00ad3e3f2f4028093ebc4092fae52aba2202fd0006258827580db00e41ebe52a402c3102b4fb7c09c2817341c32390bf5c2508274e81accf3f6da092c040e9d52138eaa4ac3e5f8058627cab08c6adbefc904e3080b512c409d7a801de1e7506ad879204e1c405f0c67cc51f4aa1509f0f9458d0008d092bd07c7809104b564fe36af8225ed0e757c5fcb1c31928091ad41e82565bf9518074e286ed8797eca34509fc87f6e17be611c81f4a74e0a213451e4a461753fb8d46b86c2ca000ad976b1ac1d5f4ab9e9e61fa5ab4bfbfff07c4078c8e8e8ebe8e3e8ae5e5247931ed217806a0f5729db7de0d227232fc76bc9327440e9040ebe5dae87a27055e01181ba961de12803b569fdf43fbaf3c2ff39e7b67672bcea0fd72fd3e172d7b7cef5942ce0458f8f4ff7e11cd96b180b1772335d6009796569c59cf6f315b07189d079dbb9d9dbbbbcdbbcd1855cd55462cf31d4d0354a0f7a7842fee8efe3bc4db54798578786f007417f0aa4f096e9fcf2f4d5962b447e0951fc73c4e08aff9dc43b0f4b798c209d77b4c98bc17000e14fd5ae9edb101f2057cf3428025beed145f40db13e065c96f3145bd9a020fc0b981ff94903aee11f8bf2464497808965ec0721322c1e25f2b7f36211a2c95904479095160390909164bc86dee01c87674fcaa1d5d2421c6026238b35becff0b889710e246c24b8962a66f8662646684e22bc628c5cae88a19a33f0418008e8f0f813207cbb40000000049454e44ae4260822b0a637265646974436f64650ce4bfa1e794a8e4bba3e7a0811239313530303130384d41355542333248334e1a0570686f6e6506e794b5e8af9d0c3032332d383633333130363927077765627369746506e5ae98e7bd911768747470733a2f2f7777772e696e636861696e2e6f7267fd1d0108646573637269707406e68f8fe8bfb0fd0a01e9878de5ba86e58db0e993bee7a791e68a80e69c89e99990e585ace58fb8e698afe4b880e5aeb6e4bba5e58cbae59d97e993bee68a80e69cafe9a9b1e58aa8e79a84e5889be696b0e59e8be4bc81e4b89aefbc8ce585b6e4b8bbe5afbce79a84e58cbae59d97e993bee7a4bee58cbae9a1b9e79bae496e636861696e2de58db0e993bee698afe4b880e4b8aae4bba5e998b2e4bcaae4b8bae59fbae7a180e4b89ae58aa1e79a84e585ace5bc80e5b9b3e58fb0efbc8ce4b8bae7a4bee4bc9ae59084e4bc81e4b89ae38081e69cbae69e84e38081e889bae69cafe5aeb6e7ad89e68f90e4be9be59381e7898ce38081e79fa5e8af86e4baa7e69d83e4bf9de68aa4e69c8de58aa1e3808202210383d2b9f1662fca332f2e041897fc74deeb433dd14ddcc565adb60b28a1fdfd6c21033c542dd71828dade6403e2293b318fcd8f653b0f9c5171fb8d89163583c5f36f022102f6c242902fddde7c285563850c4ea74018cdd4150fe0985eefc995dda32b5e752103c00f67381f7836c8083cbd0df528b51d310a15b872b5ad5a5da5cd369aa356a0c9c220d936ad91a50e918ebb8376c7335fb7d16255333ea859d64d7d4d1f309052c8f8c314a35e97d7189abb8274afa8e264b106a1e104109688473045022100e7481eab2a8eb1aef3f62dc6e8d0a9e5b69909bc19a27bf9274da6378429154d02206996b324d78e9c52bedff0fc3707b8aedac2fee1de77d81f55f91773442af579463044022035047b9080bff21dba625cb3303d85ea79812e2fc9bf9138a162020d16bbbc760220696abbc91730c918e7ff9936c72b20497c39e7b96a6b5a21e32a27f9bd1eaaf1ac"));
		
		Sha256Hash merkleHash = gengsisBlock.getBlock().buildMerkleHash();
		
		if(log.isDebugEnabled()) {
			log.debug("the gengsis block merkle hash is : {}", merkleHash);
		}
		Utils.checkState("f674d775c1cf78a65b52ca0df6fc92c2fbdf9a6c2a51b8b5a66b494b269bd96b".equals(Hex.encode(merkleHash.getBytes())), "the gengsis block merkle hash is error");
		
		if(log.isDebugEnabled()) {
			log.debug("the gengsis block hash key is : {}", gengsisBlock.getBlock().getHash());
		}
		Utils.checkState("dc717194e787e79094ded9bb61986314e00a23929740c035736f7b26ded735c8".equals(Hex.encode(gengsisBlock.getBlock().getHash().getBytes())), "the gengsis block hash is error");
		
		return gengsisBlock;
	}
	
	@Override
	public int getProtocolVersionNum(ProtocolVersion version) {
		return version.getVersion();
	}

	@Override
	public MessageSerializer getSerializer(boolean parseRetain) {
		return new DefaultMessageSerializer(this);
	}
	
	/**
	 * 获取该网络的认证管理账号的hash160
	 * @return byte[]
	 */
	@Override
	public byte[] getCertAccountManagerHash160() {
		return Hex.decode("d4f493c62957ca4916962178881af76ce6c74308");
	}
	
	/**
	 * 测试网络，普通地址以t开头
	 */
	@Override
	public int getSystemAccountVersion() {
		return 128;
	}

	/**
	 * 测试网络，认证地址以c开头
	 */
	@Override
	public int getCertAccountVersion() {
		return 88;
	}
}
