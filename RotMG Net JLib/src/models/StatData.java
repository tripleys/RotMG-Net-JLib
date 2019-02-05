package models;

import java.io.DataInput;
import java.io.IOException;

public class StatData {

	public static final byte MAX_HP_STAT = 0;
	public static final byte HP_STAT = 1;
	public static final byte SIZE_STAT = 2;
	public static final byte MAX_MP_STAT = 3;
	public static final byte MP_STAT = 4;
	public static final byte NEXT_LEVEL_EXP_STAT = 5;
	public static final byte EXP_STAT = 6;
	public static final byte LEVEL_STAT = 7;
	public static final byte ATTACK_STAT = 20;
	public static final byte DEFENSE_STAT = 21;
	public static final byte SPEED_STAT = 22;
	public static final byte INVENTORY_0_STAT = 8;
	public static final byte INVENTORY_1_STAT = 9;
	public static final byte INVENTORY_2_STAT = 10;
	public static final byte INVENTORY_3_STAT = 11;
	public static final byte INVENTORY_4_STAT = 12;
	public static final byte INVENTORY_5_STAT = 13;
	public static final byte INVENTORY_6_STAT = 14;
	public static final byte INVENTORY_7_STAT = 15;
	public static final byte INVENTORY_8_STAT = 16;
	public static final byte INVENTORY_9_STAT = 17;
	public static final byte INVENTORY_10_STAT = 18;
	public static final byte INVENTORY_11_STAT = 19;
	public static final byte VITALITY_STAT = 26;
	public static final byte WISDOM_STAT = 27;
	public static final byte DEXTERITY_STAT = 28;
	public static final byte CONDITION_STAT = 29;
	public static final byte NUM_STARS_STAT = 30;
	public static final byte NAME_STAT = 31;
	public static final byte TEX1_STAT = 32;
	public static final byte TEX2_STAT = 33;
	public static final byte MERCHANDISE_TYPE_STAT = 34;
	public static final byte CREDITS_STAT = 35;
	public static final byte MERCHANDISE_PRICE_STAT = 36;
	public static final byte ACTIVE_STAT = 37;
	public static final byte ACCOUNT_ID_STAT = 38;
	public static final byte FAME_STAT = 39;
	public static final byte MERCHANDISE_CURRENCY_STAT = 40;
	public static final byte CONNECT_STAT = 41;
	public static final byte MERCHANDISE_COUNT_STAT = 42;
	public static final byte MERCHANDISE_MINS_LEFT_STAT = 43;
	public static final byte MERCHANDISE_DISCOUNT_STAT = 44;
	public static final byte MERCHANDISE_RANK_REQ_STAT = 45;
	public static final byte MAX_HP_BOOST_STAT = 46;
	public static final byte MAX_MP_BOOST_STAT = 47;
	public static final byte ATTACK_BOOST_STAT = 48;
	public static final byte DEFENSE_BOOST_STAT = 49;
	public static final byte SPEED_BOOST_STAT = 50;
	public static final byte VITALITY_BOOST_STAT = 51;
	public static final byte WISDOM_BOOST_STAT = 52;
	public static final byte DEXTERITY_BOOST_STAT = 53;
	public static final byte OWNER_ACCOUNT_ID_STAT = 54;
	public static final byte RANK_REQUIRED_STAT = 55;
	public static final byte NAME_CHOSEN_STAT = 56;
	public static final byte CURR_FAME_STAT = 57;
	public static final byte NEXT_CLASS_QUEST_FAME_STAT = 58;
	public static final byte LEGENDARY_RANK_STAT = 59;
	public static final byte SINK_LEVEL_STAT = 60;
	public static final byte ALT_TEXTURE_STAT = 61;
	public static final byte GUILD_NAME_STAT = 62;
	public static final byte GUILD_RANK_STAT = 63;
	public static final byte BREATH_STAT = 64;
	public static final byte XP_BOOSTED_STAT = 65;
	public static final byte XP_TIMER_STAT = 66;
	public static final byte LD_TIMER_STAT = 67;
	public static final byte LT_TIMER_STAT = 68;
	public static final byte HEALTH_POTION_STACK_STAT = 69;
	public static final byte MAGIC_POTION_STACK_STAT = 70;
	public static final byte BACKPACK_0_STAT = 71;
	public static final byte BACKPACK_1_STAT = 72;
	public static final byte BACKPACK_2_STAT = 73;
	public static final byte BACKPACK_3_STAT = 74;
	public static final byte BACKPACK_4_STAT = 75;
	public static final byte BACKPACK_5_STAT = 76;
	public static final byte BACKPACK_6_STAT = 77;
	public static final byte BACKPACK_7_STAT = 78;
	public static final byte HASBACKPACK_STAT = 79;
	public static final byte TEXTURE_STAT = 80;
	public static final byte PET_INSTANCEID_STAT = 81;
	public static final byte PET_NAME_STAT = 82;
	public static final byte PET_TYPE_STAT = 83;
	public static final byte PET_RARITY_STAT = 84;
	public static final byte PET_MAXABILITYPOWER_STAT = 85;
	public static final byte PET_FAMILY_STAT = 86;
	public static final byte PET_FIRSTABILITY_POINT_STAT = 87;
	public static final byte PET_SECONDABILITY_POINT_STAT = 88;
	public static final byte PET_THIRDABILITY_POINT_STAT = 89;
	public static final byte PET_FIRSTABILITY_POWER_STAT = 90;
	public static final byte PET_SECONDABILITY_POWER_STAT = 91;
	public static final byte PET_THIRDABILITY_POWER_STAT = 92;
	public static final byte PET_FIRSTABILITY_TYPE_STAT = 93;
	public static final byte PET_SECONDABILITY_TYPE_STAT = 94;
	public static final byte PET_THIRDABILITY_TYPE_STAT = 95;
	public static final byte NEW_CON_STAT = 96;
	public static final byte FORTUNE_TOKEN_STAT = 97;
	public static final byte SUPPORTER_POINTS_STAT = 98;
	public static final byte SUPPORTER_STAT = 99;
	
	public byte statType = 0;
	public int statValue;
	public String stringValue;
	
	public void read(DataInput input) throws IOException {
		statType = input.readByte();
		if (isStringStat()) {
			statValue = input.readInt();
		} else {
			stringValue = input.readUTF();
		}
	}
	
	private boolean isStringStat() {
		switch (this.statType) {
		case NAME_STAT:
		case GUILD_NAME_STAT:
		case PET_NAME_STAT:
		case ACCOUNT_ID_STAT:
		case OWNER_ACCOUNT_ID_STAT:
			return true;
		default:
			return false;
		}
	}
}
